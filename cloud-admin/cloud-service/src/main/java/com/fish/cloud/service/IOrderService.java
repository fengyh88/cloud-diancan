package com.fish.cloud.service;

import com.fish.cloud.bean.dto.OrderCountStatusDto;
import com.fish.cloud.bean.dto.OrderDetailDto;
import com.fish.cloud.bean.dto.OrderDto;
import com.fish.cloud.bean.dto.OrderWithItemsDto;
import com.fish.cloud.bean.model.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.OrderBySatusParam;
import com.fish.cloud.bean.param.OrderCloseParam;
import com.fish.cloud.bean.param.OrderCompleteParam;
import com.fish.cloud.bean.param.OrderSendParam;
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
     * 根据台桌Id和状态查询该台桌的单据列表
     * @param tableId
     * @param status 1已提交 9已结算 13关闭，失败
     * @return
     */
    List<OrderWithItemsDto> listByTableId(Long tableId, Integer status);

    /**
     * 根据状态查询单据列表
     * @param status 1已提交 9已结算 13关闭，失败
     * @return
     */
    List<OrderWithItemsDto> listByStatus(Integer status);

    /**
     * 结算
     * @param orderCompleteParam
     * @return
     */
    TupleRet complete(OrderCompleteParam orderCompleteParam);

    /**
     * 关闭
     * @param orderCloseParam
     * @return
     */
    TupleRet close(OrderCloseParam orderCloseParam);
}
