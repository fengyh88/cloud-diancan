package com.fish.cloud.service;

import com.fish.cloud.bean.dto.OrderCountStatusDto;
import com.fish.cloud.bean.dto.OrderDetailDto;
import com.fish.cloud.bean.dto.OrderDto;
import com.fish.cloud.bean.model.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.OrderAddParam;
import com.fish.cloud.bean.param.OrderBySatusParam;
import com.fish.cloud.bean.param.OrderCancelParam;
import com.fish.cloud.bean.param.OrderPayOnlineParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IOrderService extends IService<Order> {

    /**
     * 根据状态查询列表
     * @param shopId
     * @param userId
     * @param orderBySatusParam
     * @return
     */
    public List<OrderDto> listByStatus(String shopId, String userId, OrderBySatusParam orderBySatusParam);

    /**
     * 详情
     * @param id
     * @return
     */
    public OrderDetailDto detail(Long id);

    /**
     * 统计我的订单数量
     * @param shopId
     * @param userId
     * @return
     */
    public OrderCountStatusDto countOrderStatus(String shopId, String userId);

    /**
     * 确认收货
     * @param id
     * @return
     */
    public TupleRet confirm(Long id);

    /**
     * 取消订单
     * 待付款时、待发货、待收货时可取消订单
     * @param orderCancelParam
     * @return
     */
    public TupleRet cancel(OrderCancelParam orderCancelParam);

    /**
     * 删除订单，已完成,已取消时可删除订单
     * @param id
     * @return
     */
    public TupleRet delete(Long id);

    /**
     * 提交订单
     * @param shopId
     * @param userId
     * @param orderAddParam
     * @return
     */
    public TupleRet<Long> submit(String shopId,String userId,OrderAddParam orderAddParam);

}
