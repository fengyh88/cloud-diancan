package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.OrderAddr;
import com.fish.cloud.repo.OrderAddrMapper;
import com.fish.cloud.service.IOrderAddrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单收货地址
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class OrderAddrServiceImpl extends ServiceImpl<OrderAddrMapper, OrderAddr> implements IOrderAddrService {
	
}
