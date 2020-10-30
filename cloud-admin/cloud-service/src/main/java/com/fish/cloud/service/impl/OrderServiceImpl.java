package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.Order;
import com.fish.cloud.repo.OrderMapper;
import com.fish.cloud.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
	
}
