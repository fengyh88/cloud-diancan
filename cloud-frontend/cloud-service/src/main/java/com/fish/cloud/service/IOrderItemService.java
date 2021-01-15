package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.dto.OrderItemDto;
import com.fish.cloud.bean.model.OrderItem;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 订单项
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface IOrderItemService extends IService<OrderItem> {
    /**
     * 根据OrderId获取列表
     * @param orderId
     * @return
     */
    List<OrderItemDto> listByOrderId(Long orderId);

    /**
     * 根据orderItemId删除某项
     * @param orderItemId
     */
    TupleRet deleteByOrderItemId(Long orderItemId);
}
