package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.OrderSettlement;
import com.fish.cloud.repo.OrderSettlementMapper;
import com.fish.cloud.service.IOrderSettlementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 结算
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class OrderSettlementServiceImpl extends ServiceImpl<OrderSettlementMapper, OrderSettlement> implements IOrderSettlementService {
	
}
