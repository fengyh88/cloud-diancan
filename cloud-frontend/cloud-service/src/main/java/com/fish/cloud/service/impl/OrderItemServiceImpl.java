package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.dto.OrderItemDto;
import com.fish.cloud.bean.model.Order;
import com.fish.cloud.bean.model.OrderItem;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.repo.OrderItemMapper;
import com.fish.cloud.service.IOrderItemService;
import com.fish.cloud.service.IOrderService;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 订单项
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {

    @Autowired
    private IOrderService orderService;

    @Override
    public List<OrderItemDto> listByOrderId(Long orderId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<OrderItem>()
                .eq(OrderItem::getOrderId, orderId)
                .ne(OrderItem::getStatus, 0));
        // dto
        List<OrderItemDto> dtoList = models.stream().map(model -> {
            var dto = new OrderItemDto();
            BeanUtils.copyProperties(model, dto);
            return dto;
        }).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public TupleRet deleteByOrderItemId(Long orderItemId) {
        // 更新状态
        OrderItem orderItem = baseMapper.selectById(orderItemId);
        Order order = orderService.getById(orderItem.getOrderId());
        if (1 != order.getStatus()){
            return TupleRet.failed("订单已结算或者已关闭");
        }
        if (1 != orderItem.getStatus()){
            return TupleRet.failed("已出餐或者已删除");
        }
        // 执行明细移除操作
        orderItem.setStatus(0);
        baseMapper.updateById(orderItem);
        // 重新计算订单信息
        orderService.calOrder(order);
        return TupleRet.success();
    }
}
