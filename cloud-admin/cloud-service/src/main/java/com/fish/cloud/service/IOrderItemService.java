package com.fish.cloud.service;

import com.fish.cloud.bean.dto.OrderItemDto;
import com.fish.cloud.bean.model.OrderItem;
import com.baomidou.mybatisplus.extension.service.IService;
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
     * 更新状态
     * @param id
     * @param status
     * @return
     */
    TupleRet status(Long id, Integer status);
}
