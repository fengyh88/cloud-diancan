package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.dto.OrderDetailDto;
import com.fish.cloud.bean.dto.OrderDto;
import com.fish.cloud.bean.model.Order;
import com.fish.cloud.bean.model.OrderItem;
import com.fish.cloud.bean.param.OrderAddItemParam;
import com.fish.cloud.bean.param.OrderAddParam;
import com.fish.cloud.bean.param.OrderBySatusParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.common.util.IdUtil;
import com.fish.cloud.repo.OrderMapper;
import com.fish.cloud.service.ICartService;
import com.fish.cloud.service.IOrderItemService;
import com.fish.cloud.service.IOrderService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private IOrderItemService orderItemService;
    @Autowired
    private ICartService cartService;

    @ApiOperation("根据状态查询列表")
    @Override
    public List<OrderDto> listByStatus(OrderBySatusParam orderBySatusParam) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<Order>()
                .eq(Order::getShopId, ApiContextHolder.getShopId())
                .eq(Order::getTableId, ApiContextHolder.getTableId())
                .eq(Order::getUserId, ApiContextHolder.getAuthDto().getUserId())
                .eq(0 != orderBySatusParam.getStatus(), Order::getStatus, orderBySatusParam.getStatus()));
        // dto
        List<OrderDto> dtoList = models.stream().map(model -> {
            var dto = new OrderDto();
            BeanUtils.copyProperties(model, dto);
            return dto;
        }).collect(Collectors.toList());
        return dtoList;
    }

    @ApiOperation("详情")
    @Override
    public OrderDetailDto detail(Long id) {
        var model = baseMapper.selectById(id);
        // dto
        OrderDetailDto dto = new OrderDetailDto();
        BeanUtils.copyProperties(model, dto);
        //订单项
        var orderItems = orderItemService.listByOrderId(id);
        dto.setOrderItems(orderItems);

        return dto;
    }

    /**
     * 提交订单
     * @param orderAddParam
     * @return
     */
    @Transactional
    @Override
    public TupleRet<Long> submit(OrderAddParam orderAddParam) {
        // 提交订单主表
        Order order = new Order();
        order.setShopId(ApiContextHolder.getShopId());
        order.setTableId(ApiContextHolder.getTableId());
        order.setUserId(ApiContextHolder.getAuthDto().getUserId());
        order.setProdName("");
        order.setOrderNumber(IdUtil.getOrderNumberByTime(ApiContextHolder.getShopId()));
        order.setOrderType(1); // 暂固定值
        // 金额
        order.setTotalAmount(orderAddParam.getTotalAmount());
        order.setReduceAmount(orderAddParam.getReduceAmount());
        order.setActualAmount(orderAddParam.getActualAmount());
        // 支付
        order.setPayType(orderAddParam.getPayType()); // 微信支付
        order.setIsPayed(0); // 未支付
        order.setRemark(orderAddParam.getRemark());
        order.setStatus(1); // 已提交状态
        // 商品总数
        Integer prodNum = orderAddParam.getItems().stream().mapToInt(OrderAddItemParam::getNum).sum();
        order.setProdNum(prodNum);
        order.setCreateTime(DateTimeUtil.getCurrentDateTime());

        try {
            baseMapper.insert(order);
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
                orderItem.setTableId(ApiContextHolder.getTableId());
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

                orderItems.add(orderItem);
            });

            orderItemService.saveBatch(orderItems);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        // 清空购物车
        TupleRet retClear = cartService.clearByUserIdAndShopId(ApiContextHolder.getAuthDto().getUserId(), ApiContextHolder.getShopId());
        if (!retClear.getSuccess()) {
            return TupleRet.failed("清空购物车错误");
        }

        return TupleRet.success(order.getOrderId());
    }
}
