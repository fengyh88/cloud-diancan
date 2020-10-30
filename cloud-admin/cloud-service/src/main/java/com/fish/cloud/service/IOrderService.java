package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.OrderDetailDto;
import com.fish.cloud.bean.dto.OrderDto;
import com.fish.cloud.bean.page.PageParam;
import com.fish.cloud.bean.dto.OrderCountStatusDto;
import com.fish.cloud.bean.model.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.OrderBySatusParam;
import com.fish.cloud.bean.param.OrderCancelParam;
import com.fish.cloud.bean.param.OrderSendParam;
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
     * @param orderBySatusParam
     * @return
     */
    List<OrderDto> listByStatus(String shopId, OrderBySatusParam orderBySatusParam);

    /**
     * 详情
     * @param id
     * @return
     */
    OrderDetailDto detail(Long id);

    /**
     * 统计我的订单数量
     * @param shopId
     * @return
     */
    OrderCountStatusDto countOrderStatus(String shopId);

    /**
     * 通过取消申请
     * @param orderId
     * @return
     */
    TupleRet cancelPass(Long orderId);

    /**
     * 发货
     * @param orderSendParam
     * @return
     */
    TupleRet send(OrderSendParam orderSendParam);

    /**
     * 确定不发货，取消订单
     * @param orderId
     * @return
     */
    TupleRet notSend(Long orderId);

    /**
     * 查询30分钟未支付的列表
     * @param min
     * @return
     */
    List<Order> listNotPayForMin(Integer min) ;

    /**
     * 查询15天之前未确认收货的列表
     * @param day
     * @return
     */
    List<Order> listNotConfirmForDays(Integer day) ;

    /**
     * 确认收货，15天之前未确认收货的
     * @param order
     * @return
     */
    TupleRet confirm(Order order);

    /**
     * 取消订单，30分钟未支付的
     * @param order
     * @return
     */
    TupleRet cancel(Order order);
}
