package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.OrderCountStatusDto;
import com.fish.cloud.bean.dto.OrderDetailDto;
import com.fish.cloud.bean.dto.OrderDto;
import com.fish.cloud.bean.dto.OrderItemDto;
import com.fish.cloud.bean.model.Order;
import com.fish.cloud.bean.model.Prod;
import com.fish.cloud.bean.param.OrderBySatusParam;
import com.fish.cloud.bean.param.OrderCompleteParam;
import com.fish.cloud.bean.param.OrderSendParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.OrderMapper;
import com.fish.cloud.service.IOrderItemService;
import com.fish.cloud.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.service.IProdService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;
import java.time.Instant;
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

    @ApiOperation("根据状态查询列表")
    @Override
    public List<OrderDto> listByStatus(OrderBySatusParam orderBySatusParam) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<Order>()
        .eq(Order::getShopId,ApiContextHolder.getShopId())
        .eq(0 != orderBySatusParam.getStatus(),Order::getStatus, orderBySatusParam.getStatus()));
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

    @ApiOperation("统计店铺订单数量")
    @Override
    public OrderCountStatusDto countOrderStatus() {
        return baseMapper.countOrderStatus(ApiContextHolder.getShopId());
    }

    /**
     * 完成
     * @param orderCompleteParam
     * @return
     */
    @Override
    public TupleRet complete(OrderCompleteParam orderCompleteParam) {
        var model = baseMapper.selectById(orderCompleteParam.getOrderId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("订单不存在") ;
        }

        // 判断订单状态，此系统不判断

        // 更新状态，13:关闭，失败，17:完成，成功
        model.setStatus(orderCompleteParam.getStatus());
        model.setCompleteTime(DateTimeUtil.getCurrentDateTime());

        try {
            baseMapper.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return  TupleRet.failed("失败");
        }

        return TupleRet.success("成功");
    }
}
