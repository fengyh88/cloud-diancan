package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.OrderItemDto;
import com.fish.cloud.bean.model.OrderItem;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.ImgUrlUtil;
import com.fish.cloud.repo.OrderItemMapper;
import com.fish.cloud.service.IOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
@Slf4j
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {
    @Override
    public List<OrderItemDto> listByOrderId(Long orderId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<OrderItem>()
                .eq(OrderItem::getOrderId, orderId)
                .ne(OrderItem::getStatus, -1)); // 不包含已经删除的
        // dto
        List<OrderItemDto> dtoList = models.stream().map(model -> {
            var dto = new OrderItemDto();
            BeanUtils.copyProperties(model, dto);
            dto.setProdImg(ImgUrlUtil.getFullPathImgUrl(dto.getProdImg()));
            dto.setSkuImg(ImgUrlUtil.getFullPathImgUrl(dto.getSkuImg()));
            return dto;
        }).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public TupleRet status(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("订单项不存在");
        }

        try {
            model.setStatus(status);
            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success();
    }
}
