package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.OrderItemDto;
import com.fish.cloud.bean.model.OrderItem;
import com.fish.cloud.common.util.ImgUrlUtil;
import com.fish.cloud.repo.OrderItemMapper;
import com.fish.cloud.service.IOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.beans.BeanUtils;
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
    @Override
    public List<OrderItemDto> listByOrderId(Long orderId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<OrderItem>()
                .eq(OrderItem::getOrderId, orderId)
                .ne(OrderItem::getStatus, -1)); // 不包含已经删除的
        // dto
        var dtoList = models.stream().map(model -> {
            var dto = new OrderItemDto();
            BeanUtils.copyProperties(model, dto);
            dto.setProdImg(ImgUrlUtil.getFullPathImgUrl(dto.getProdImg()));
            dto.setSkuImg(ImgUrlUtil.getFullPathImgUrl(dto.getSkuImg()));
            return dto;
        }).collect(Collectors.toList());
        return dtoList;
    }
}
