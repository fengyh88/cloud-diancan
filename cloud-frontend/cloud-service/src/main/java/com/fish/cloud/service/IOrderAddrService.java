package com.fish.cloud.service;

import com.fish.cloud.bean.model.OrderAddr;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单收货地址
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IOrderAddrService extends IService<OrderAddr> {
    /**
     * 根据OrderId获取
     * @param orderId
     * @return
     */
	OrderAddr getByOrderId(Long orderId);
}
