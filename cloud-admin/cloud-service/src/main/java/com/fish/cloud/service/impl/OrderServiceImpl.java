package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.OrderWithItemsDto;
import com.fish.cloud.bean.model.Order;
import com.fish.cloud.bean.param.OrderCloseParam;
import com.fish.cloud.bean.param.OrderCompleteParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.OrderMapper;
import com.fish.cloud.service.IOrderItemService;
import com.fish.cloud.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.service.ITableService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
    private ITableService tableService;

    @Override
    public List<OrderWithItemsDto> listByTableId(Long tableId, Integer status) {
        List<Order> models = baseMapper.selectList(new LambdaQueryWrapper<Order>()
                .eq(Order::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Order::getTableId, tableId)
                .eq(Order::getStatus, status));
        // dto
        List<OrderWithItemsDto> dtoList = models.stream().map(model -> {
            var dto = new OrderWithItemsDto();
            BeanUtils.copyProperties(model, dto);
            //订单项
            var orderItems = orderItemService.listByOrderId(dto.getOrderId());
            dto.setOrderItems(orderItems);
            return dto;
        }).collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public TupleRet complete(OrderCompleteParam orderCompleteParam) {
        var model = baseMapper.selectById(orderCompleteParam.getOrderId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("订单不存在");
        }

        // 判断订单状态
        if(9 ==  model.getStatus()){
            return TupleRet.failed("订单已结算，不得重复结算");
        }
        if(13 ==  model.getStatus()){
            return TupleRet.failed("订单已关闭");
        }

        model.setTotalAmount(orderCompleteParam.getTotalAmount());
        model.setReduceAmount(orderCompleteParam.getReduceAmount());
        model.setActualAmount(orderCompleteParam.getActualAmount());
        model.setPayType(orderCompleteParam.getPayType());
        model.setStatus(9); // 9表示已结算
        model.setCompleteTime(DateTimeUtil.getCurrentDateTime());

        try {
            baseMapper.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return  TupleRet.failed(e.getMessage());
        }

        // 更新台桌状态为空桌
        tableService.status(model.getTableId(), 1);// 1表示空桌

        return TupleRet.success();
    }

    @Override
    public TupleRet close(OrderCloseParam orderCloseParam) {
        var model = baseMapper.selectById(orderCloseParam.getOrderId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("订单不存在");
        }

        // 判断订单状态
        if(9 ==  model.getStatus()){
            return TupleRet.failed("订单已结算，不得关闭");
        }

        model.setStatus(13); // 13表示关闭
        model.setCompleteTime(DateTimeUtil.getCurrentDateTime());

        try {
            baseMapper.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return  TupleRet.failed(e.getMessage());
        }

        // 更新台桌状态为空桌
        tableService.status(model.getTableId(), 1);// 1表示空桌

        return TupleRet.success();
    }
}
