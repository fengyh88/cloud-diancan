package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.OrderItem;
import com.fish.cloud.repo.OrderItemMapper;
import com.fish.cloud.service.IOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单项
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {
	
}
