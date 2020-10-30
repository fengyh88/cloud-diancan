package com.fish.cloud.service.impl;

import com.fish.cloud.bean.dto.OrderCountStatusDto;
import com.fish.cloud.bean.dto.OrderDetailDto;
import com.fish.cloud.bean.dto.OrderDto;
import com.fish.cloud.bean.dto.OrderItemDto;
import com.fish.cloud.bean.model.*;
import com.fish.cloud.bean.param.OrderAddItemParam;
import com.fish.cloud.bean.param.OrderAddParam;
import com.fish.cloud.bean.param.OrderBySatusParam;
import com.fish.cloud.bean.param.OrderCancelParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.common.util.IdUtil;
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
    @Autowired
    private IUserAddrService userAddrService;
    @Autowired
    private ICartService cartService;

    @Override
    public List<OrderDto> listByStatus(String shopId, String userId, OrderBySatusParam orderBySatusParam) {
        var models = baseMapper.listByStatus(shopId, userId, orderBySatusParam);
        models.forEach(orderDto -> {
            //订单项
            var orderItems = orderItemService.listByOrderId(orderDto.getOrderId());
            orderDto.setOrderItems(orderItems);
        });
        return models;
    }

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

    @Override
    public OrderCountStatusDto countOrderStatus(String shopId, String userId) {
        return baseMapper.countOrderStatus(shopId, userId);
    }

    /**
     * 确认收货
     * @param id
     * @return
     */
    @Override
    public TupleRet confirm(Long id) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("订单不存在");
        }

        // 0全部  1:待付款 2:已付款 3:已发货 4:已收货 5:已评价 6:已取消 （取消审核通过，不发货），7:已删除 回收站 8:已删除 永久删除 11:取消订单审核中
        // 状态判断，待付款时、待发货、待收货时可取消订单
        switch (model.getStatus()){
            case 6:
                return TupleRet.failed("订单已取消");
            case 7:
            case 8:
                return TupleRet.failed("订单已删除");
            case 11:
                return TupleRet.failed("订单取消申请中");
            case 1:
                return TupleRet.failed("订单未付款");
            case 2:
                return TupleRet.failed("订单未发货");
            case 4:
            case 5:
                return TupleRet.failed("订单已完成");
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
     * 取消订单
     * 待付款时、待发货、待收货时可取消订单
     * @param orderCancelParam
     * @return
     */
    @Override
    public TupleRet cancel(OrderCancelParam orderCancelParam) {
        var model = baseMapper.selectById(orderCancelParam.getId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("订单不存在");
        }

        // 0全部  1:待付款 2:已付款 3:已发货 4:已收货 5:已评价 6:已取消 （取消审核通过，不发货），7:已删除 回收站 8:已删除 永久删除 11:取消订单审核中
        // 状态判断，待付款时、待发货、待收货时可取消订单
        switch (model.getStatus()){
            case 6:
                return TupleRet.failed("订单已取消");
            case 7:
            case 8:
                return TupleRet.failed("订单已关闭");
            case 11:
                return TupleRet.failed("订单取消申请中");
            case 4:
            case 5:
                return TupleRet.failed("订单已完成");
        }

        // 如果是2:已付款 3:已发货，则提交审核
        if (model.getStatus() == 2 || model.getStatus() == 3) {
            model.setStatus(11);
            return TupleRet.success("取消申请已提交，请等候商家审核");
        }

        // 如果是1：待付款状态，则直接取消订单
        // 6:已取消 （用户未支付直接取消订单，取消审核通过，不发货）
        model.setStatus(6);
        model.setCloseType(4);
        model.setCancelTime(DateTimeUtil.getCurrentDateTime());

        // 恢复商品库存
        if(!returnProdStock(orderCancelParam.getId())) {
            return TupleRet.failed("恢复商品库存失败");
        }

        try {
            baseMapper.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("取消失败");
        }

        return TupleRet.success();
    }

    /**
     * 删除订单，已完成,已取消时可删除订单
     * @param id
     * @return
     */
    @Override
    public TupleRet delete(Long id) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("订单不存在");
        }

        // 0全部  1:待付款 2:已付款 3:已发货 4:已收货 5:已评价 6:已取消 （取消审核通过，不发货），7:已删除 回收站 8:已删除 永久删除 11:取消订单审核中
        // 状态判断，已完成，已取消时才可删除订单
        switch (model.getStatus()){
            case 7:
            case 8:
                return TupleRet.failed("订单已关闭");
            case 11:
                return TupleRet.failed("订单取消申请中");
            case 1:
            case 2:
            case 3:
                return TupleRet.failed("订单未完成");
        }

        try {
            // 7:已删除 回收站
            model.setStatus(7);
            baseMapper.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("删除失败");
        }

        return TupleRet.success();
    }

    /**
     * 提交订单
     * @param shopId
     * @param userId
     * @param orderAddParam
     * @return
     */
    @Transactional
    @Override
    public TupleRet<Long> submit(String shopId,String userId,OrderAddParam orderAddParam) {
        // 提交订单主表
        Order order = new Order();
        order.setOrderId(Long.getLong(IdUtil.getIdByUUId()));
        order.setShopId(shopId);
        order.setUserId(userId);
        order.setProdName("");
        order.setOrderNumber(IdUtil.getOrderNumberByTime(shopId));
        order.setOrderType(1); // 暂固定值
        // 金额
        order.setTotalAmount(orderAddParam.getTotalAmount());
        order.setReduceAmount(orderAddParam.getReduceAmount());
        order.setActualAmount(orderAddParam.getActualAmount());
        // 支付
        order.setPayType(1); // 微信支付
        order.setIsPayed(0); // 未支付
        order.setRemark(orderAddParam.getRemark());
        order.setStatus(1); // 待支付状态
        // 配送
        order.setDvyAmount(orderAddParam.getDvyAmount());
        order.setDvyType(orderAddParam.getDvyType());
        order.setDvyId(orderAddParam.getDvyId());
        // 商品总数
        final Integer[] prodNum = {0};
        orderAddParam.getItems().forEach(item -> prodNum[0] = prodNum[0] + item.getNum());
        order.setProdNum(prodNum[0]);
        // 售后
        order.setRefundStatus(0); // 售后处理，未售后状态
        order.setCloseType(0); // 关闭原因，未关闭
        order.setCreateTime(DateTimeUtil.getCurrentDateTime());

        try {
            baseMapper.insert(order);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        // 获取用户地址详情
        UserAddr userAddr = userAddrService.getById(orderAddParam.getUserAddrId());
        if (ObjectUtils.isEmpty(userAddr)) {
            return TupleRet.failed("用户地址不存在");
        }

        // 添加订单收货地址
        try {
            OrderAddr orderAddr = new OrderAddr();
            orderAddr.setOrderId(order.getOrderId());
            orderAddr.setAddrId(userAddr.getAddrId());
            orderAddr.setReceiver(userAddr.getReceiver());
            orderAddr.setMobile(userAddr.getMobile());
            orderAddr.setProvinceId(userAddr.getProvinceId());
            orderAddr.setProvince(userAddr.getProvince());
            orderAddr.setCityId(userAddr.getCityId());
            orderAddr.setCity(userAddr.getCity());
            orderAddr.setAreaId(userAddr.getAreaId());
            orderAddr.setArea(userAddr.getArea());
            orderAddr.setAddr(userAddr.getAddr());
            orderAddr.setPostCode(userAddr.getPostCode());
            orderAddr.setCreateTime(DateTimeUtil.getCurrentDateTime());

            orderAddrService.save(orderAddr);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        // 添加订单明细
        try {
            List<OrderItem> orderItems = new ArrayList<>();
            orderAddParam.getItems().forEach(item -> {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderId(order.getOrderId());
                orderItem.setProdId(item.getProdId());
                orderItem.setProdName(item.getProdName());
                orderItem.setProdImg(item.getProdImg());
                orderItem.setSkuId(item.getSkuId());
                orderItem.setSkuName(item.getSkuName());
                orderItem.setSkuImg(item.getSkuImg());
                orderItem.setNum(item.getNum());
                orderItem.setPrice(item.getPrice());
                orderItem.setTotalAmount(item.getTotalAmount());
                orderItem.setCreateTime(DateTimeUtil.getCurrentDateTime());
                orderItem.setCommentStatus(0); // 未评价

                orderItems.add(orderItem);
            });

            orderItemService.saveBatch(orderItems);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        // 清空购物车
        TupleRet retClear = cartService.clearByUserIdAndShopId(userId, shopId);
        if (!retClear.getSuccess()) {
            return TupleRet.failed("清空购物车错误");
        }

        // 提交订单，则直接减库存
        TupleRet retMinusStock = minusProdStock(orderAddParam.getItems());
        if (!retMinusStock.getSuccess()){
            return TupleRet.failed("扣减库存失败");
        }

        return TupleRet.success(order.getOrderId());
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

    /**
     * 提交订单时，减商品库存
     * @param orderItems
     * @return
     */
    private TupleRet minusProdStock(List<OrderAddItemParam> orderItems) {
        List<Prod> prods = new ArrayList<>();
        // 循环订单明细，转换获取减库存后的商品列表
        orderItems.forEach(item -> {
            Prod prod = prodService.getById(item.getProdId());
            if (!ObjectUtils.isEmpty(prod)) {
                prod.setStock(prod.getStock() - item.getNum());
                prod.setSold(prod.getSold() + item.getNum());
                prods.add(prod);
            }
        });
        // 判断库存是否不足
        for (Prod prod:prods) {
            if (prod.getStock() < 0) {
                return TupleRet.failed(prod.getProdName() + "库存不足");
            }
        }
        // 更新库存
        try {
            prodService.updateBatchById(prods);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed(e.getMessage());
        }
        return TupleRet.success();
    }
}