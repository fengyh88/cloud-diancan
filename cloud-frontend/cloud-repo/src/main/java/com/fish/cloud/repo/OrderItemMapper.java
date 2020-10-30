package com.fish.cloud.repo;

import com.fish.cloud.bean.dto.OrderItemDto;
import com.fish.cloud.bean.model.OrderItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 订单项
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface OrderItemMapper extends BaseMapper<OrderItem> {
    /**
     * 根据OrderId获取列表
     * @param orderId
     * @return
     */
    List<OrderItemDto> listByOrderId(@Param("orderId") Long orderId);
}