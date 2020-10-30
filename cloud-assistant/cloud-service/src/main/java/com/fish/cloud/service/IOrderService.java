package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.page.PageParam;
import com.fish.cloud.bean.dto.OrderCountStatusDto;
import com.fish.cloud.bean.model.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.OrderBySatusParam;
import com.fish.cloud.bean.param.OrderCancelParam;
import com.fish.cloud.common.util.TupleRet;

import java.util.List;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IOrderService extends IService<Order> {

    public TupleRet<List<Order>> listByStatus(OrderBySatusParam orderBySatusParam);

    public TupleRet<Page<Order>> pageByStatus(OrderBySatusParam orderBySatusParam, PageParam<Order> page);

    Boolean updateStatus(Long id, Integer status);

    public TupleRet cancel(OrderCancelParam orderCancelParam);

    public TupleRet<OrderCountStatusDto> getCountStatus();

    public TupleRet<Order> detail(Long orderId);

    /**
     * 确定不发货，取消订单
     * @param orderId
     * @return
     */
    public TupleRet sendNo(Long orderId);

    /**
     * 取消订单审核
     * @param orderId
     * @return
     */
    public TupleRet cancelAudit(Long orderId);

    /**
     * 发货
     * @param orderId
     * @return
     */
    public TupleRet send(Long orderId);
}
