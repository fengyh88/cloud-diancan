package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.OrderDetailDto;
import com.fish.cloud.bean.dto.OrderDto;
import com.fish.cloud.bean.dto.OrderItemDto;
import com.fish.cloud.bean.model.Prod;
import com.fish.cloud.bean.dto.OrderCountStatusDto;
import com.fish.cloud.bean.model.Order;
import com.fish.cloud.bean.param.OrderBySatusParam;
import com.fish.cloud.bean.param.OrderSendParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.OrderMapper;
import com.fish.cloud.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private IOrderItemService orderItemService;
    @Autowired
    private IOrderAddrService orderAddrService;
    @Autowired
    private IProdService prodService;

    /**
     * 查询30分钟未支付的列表
     * @param min
     * @return
     */
    @Override
    public List<Order> listNotPayForMin(Integer min) {
        // 获取min时间之前的时间
        Instant before = Instant.now().minus(Duration.ofMinutes(min));
        var models = baseMapper.selectList(new LambdaQueryWrapper<Order>()
                .eq(Order::getStatus, 1) // 1:待付款 2:已付款
                .lt(Order::getCreateTime, before));
        return models;
    }

    /**
     * 查询15天之前未确认收货的列表
     * @param day
     * @return
     */
    @Override
    public List<Order> listNotConfirmForDays(Integer day) {
        // 获取day天之前的时间
        Instant before = Instant.now().minus(Duration.ofDays(day));
        var models = baseMapper.selectList(new LambdaQueryWrapper<Order>()
                .eq(Order::getStatus, 3) // 1:待付款 2:已付款 3:已发货
                .lt(Order::getDvyTime, before));
        return models;
    }

    /**
     * 确认收货，15天之前未确认收货的自动确认收货
     * @param order
     * @return
     */
    @Override
    public TupleRet confirm(Order order){
        var model = baseMapper.selectById(order.getOrderId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("订单不存在");
        }

        // 0全部  1:待付款 2:已付款 3:已发货 4:已收货 5:已评价 6:已取消 （取消审核通过，不发货），7:已删除 回收站 8:已删除 永久删除 11:取消订单审核中
        switch (model.getStatus()){
            case 6:
            case 7:
            case 8:
                return TupleRet.failed("订单已关闭");
            case 11:
                return TupleRet.failed("订单取消申请中");
            case 5:
                return TupleRet.failed("订单已完成");
            case 1:
                return TupleRet.failed("订单未支付");
            case 2:
                return TupleRet.failed("订单未发货");
            case 4:
                return TupleRet.failed("已确认收货");
        }

        // 4:已收货
        model.setStatus(4);
        model.setFinishTime(DateTimeUtil.getCurrentDateTime());

        try {
            baseMapper.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("确认收货失败");
        }

        return TupleRet.success();
    }

    /**
     * 取消订单，30分钟未支付的自动取消订单
     * @param order
     * @return
     */
    @Override
    public TupleRet cancel(Order order) {
        var model = baseMapper.selectById(order.getOrderId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("订单不存在");
        }

        if (model.getStatus() != 1) {
            return TupleRet.failed("订单不是未支付");
        }

        // 6:已取消 （取消审核通过，不发货）
        model.setStatus(6);
        // 订单关闭原因 1-超时未支付 2-买家取消 3-卖家退款取消  5-已通过货到付款交易
        model.setCloseType(1);

        //恢复商品库存
        if(!returnProdStock(order.getOrderId())) {
            return TupleRet.failed("恢复商品库存失败");
        }

        try {
            baseMapper.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("取消失败");
        }

        return TupleRet.success("取消成功");
    }

    @ApiOperation("根据状态查询列表")
    @Override
    public List<OrderDto> listByStatus(String shopId, OrderBySatusParam orderBySatusParam) {
        var models = baseMapper.listByStatus(shopId, orderBySatusParam);
        return models;
    }

    @ApiOperation("详情")
    @Override
    public OrderDetailDto detail(Long id) {
        var model = baseMapper.detail(id);

        //订单项
        var orderItems = orderItemService.listByOrderId(id);
        model.setOrderItems(orderItems);

        //订单地址
        var orderAddr = orderAddrService.getByOrderId(id);
        model.setOrderAddr(orderAddr);

        return model;
    }

    @ApiOperation("统计店铺订单数量")
    @Override
    public OrderCountStatusDto countOrderStatus(String shopId) {
        return baseMapper.countOrderStatus(shopId);
    }

    @Transactional
    @Override
    public TupleRet cancelPass(Long orderId) {
        var model = baseMapper.selectById(orderId);
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("订单不存在") ;
        }

        //订单已删除或者已发货或者已取消
        if (model.getStatus() != 11) {
            return TupleRet.failed("未申请");
        }

        // 6 已取消状态
        model.setStatus(6);
        // 订单关闭原因 1-超时未支付 2-买家取消 3-卖家退款取消  5-已通过货到付款交易
        model.setCloseType(2);
        model.setCancelTime(DateTimeUtil.getCurrentDateTime());

        try {
            baseMapper.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("通过取消申请失败");
        }

        //恢复商品库存
        if(!returnProdStock(orderId)) {
            return TupleRet.failed("恢复商品库存失败");
        }

        //如果已在线支付
        if (model.getIsPayed() == 1 && model.getPayType() == 1) {
            //退款到微信账户
            var toWxAccount = returnToWxAccount(model);
            if (!toWxAccount.getSuccess()) {
                return TupleRet.failed(toWxAccount.getMessage());
            }
        }

        return TupleRet.success("通过取消申请成功");
    }

    /**
     * 发货
     * @param orderSendParam
     * @return
     */
    @Override
    public TupleRet send(OrderSendParam orderSendParam) {
        var model = baseMapper.selectById(orderSendParam.getOrderId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("订单不存在") ;
        }

        //订单已删除或者已发货或者已取消
        switch (model.getStatus()){
            case 6:
            case 7:
            case 8:
                return TupleRet.failed("订单已关闭");
            case 11:
                return TupleRet.failed("订单取消申请中");
            case 4:
            case 5:
                return TupleRet.failed("订单已完成");
            case 1:
                return TupleRet.failed("订单未支付");
            case 3:
                return TupleRet.failed("不得重复发货");
        }

        // 状态为3 已发货状态
        model.setStatus(3);
        model.setDvyTime(DateTimeUtil.getCurrentDateTime());
        model.setDvyId(orderSendParam.getDvyId());
        model.setDvyType(orderSendParam.getDvyType());
        model.setDvyNumber(orderSendParam.getDvyNumber());

        try {
            baseMapper.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return  TupleRet.failed("发货失败");
        }

        return TupleRet.success("发货成功");
    }

    @Transactional
    @Override
    public TupleRet notSend(Long orderId) {
        var model = baseMapper.selectById(orderId);
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("订单不存在") ;
        }

        //订单已删除或者已发货或者已取消
        switch (model.getStatus()){
            case 6:
            case 7:
            case 8:
                return TupleRet.failed("订单已关闭");
            case 11:
                return TupleRet.failed("订单取消申请中");
            case 4:
            case 5:
                return TupleRet.failed("订单已完成");
            case 3:
                return TupleRet.failed("订单已发货");
        }

        // 6已取消
        model.setStatus(6);
        // 订单关闭原因 1-超时未支付 2-买家取消 3-卖家退款取消  5-已通过货到付款交易
        model.setCloseType(3);
        model.setCancelTime(DateTimeUtil.getCurrentDateTime());

        try {
            baseMapper.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed(e.getMessage());
        }

        //恢复商品库存
        if(!returnProdStock(orderId)) {
            return TupleRet.failed("恢复库存失败");
        }

        //如果已在线支付
        if (model.getStatus() == 2 && model.getPayType() == 1) {
            //退款到微信账户
            var toWxAccount = returnToWxAccount(model);
            if (!toWxAccount.getSuccess()) {
                return TupleRet.failed(toWxAccount.getMessage());
            }
        }

        return TupleRet.success();
    }

    private TupleRet returnToWxAccount(Order orderModel){
        return TupleRet.failed();
    }

    /**
     * 取消订单时，恢复商品库存
     * @param orderId
     * @return
     */
    private Boolean returnProdStock(Long orderId) {
        List<OrderItemDto> orderItems = orderItemService.listByOrderId(orderId);

        List<Prod> prods = new ArrayList<>();
        orderItems.forEach(item -> {
            Prod prod = prodService.getById(item.getProdId());
            if (!ObjectUtils.isEmpty(prod)) {
                prod.setStock(prod.getStock() + item.getNum());
                prod.setSold(prod.getSold() - item.getNum());
                prods.add(prod);
            }
        });
        try {
            prodService.updateBatchById(prods);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
        return true;
    }
}