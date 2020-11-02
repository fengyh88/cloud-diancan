package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.dto.OrderDetailDto;
import com.fish.cloud.bean.dto.OrderDto;
import com.fish.cloud.bean.model.Order;
import com.fish.cloud.bean.param.OrderAddParam;
import com.fish.cloud.bean.param.OrderBySatusParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface IOrderService extends IService<Order> {

    /**
     * 根据状态查询列表
     * @param orderBySatusParam
     * @return
     */
    List<OrderDto> listByStatus(OrderBySatusParam orderBySatusParam);

    /**
     * 详情
     * @param id
     * @return
     */
    OrderDetailDto detail(Long id);

    /**
     * 提交订单
     * @param orderAddParam
     * @return
     */
    public TupleRet<Long> submit(OrderAddParam orderAddParam);
}
