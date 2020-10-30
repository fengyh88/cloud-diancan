package com.fish.cloud.api.controller;

import com.fish.cloud.bean.page.PageParam;
import com.fish.cloud.bean.model.Order;
import com.fish.cloud.bean.param.OrderBySatusParam;
import com.fish.cloud.bean.param.OrderCancelParam;
import com.fish.cloud.common.util.TupleRet;
import com.fish.cloud.service.IOrderService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @ApiOperation("根据状态查询列表")
    @PostMapping(value = "/listByStatus")
    public TupleRet listByStatus(@RequestBody OrderBySatusParam orderBySatusParam) {
        if (!ArrayUtils.contains(new int[]{0, 1, 2, 3, 4}, orderBySatusParam.getStatus())) {
            return TupleRet.failed("未设置查询的订单状态或者订单状态设置错误");
        }
        return orderService.listByStatus(orderBySatusParam);
    }

    @ApiOperation("根据状态查询列表，分页")
    @PostMapping(value = "/pageByStatus")
    public TupleRet pageByStatus(@RequestBody OrderBySatusParam orderBySatusParam, PageParam<Order> page) {
        if (!ArrayUtils.contains(new int[]{0, 1, 2, 3, 4, 11, 10}, orderBySatusParam.getStatus())) {
            return TupleRet.failed("未设置查询的订单状态或者订单状态设置错误");
        }
        return orderService.pageByStatus(orderBySatusParam, page);
    }

    @ApiOperation("订单各个状态数量")
    @GetMapping(value = "/getCountStatus")
    public TupleRet getCountStatus() {
        return orderService.getCountStatus();
    }

    @ApiOperation("取消订单")
    @PostMapping(value = "/cancel")
    public TupleRet cancel(@RequestBody OrderCancelParam orderCancelParam) {
        return orderService.cancel(orderCancelParam);
    }

    @ApiOperation("订单详情")
    @GetMapping(value = "/detail")
    public TupleRet<Order> detail(@RequestParam(value = "id") Long id) {
        return orderService.detail(id);
    }

    @ApiOperation("取消订单审核")
    @GetMapping(value = "/cancelAudit")
    public TupleRet cancelAudit(@RequestParam(value = "id") Long id) {
        return orderService.cancelAudit(id);
    }

    @ApiOperation("发货")
    @PostMapping(value = "/send/{orderId}")
    public TupleRet send(@PathVariable Long orderId) {
        return orderService.send(orderId);
    }

    @ApiOperation("确定不发货，取消订单")
    @GetMapping(value = "/sendNo")
    public TupleRet sendNo(@RequestParam(value = "id") long id) {
        return orderService.sendNo(id);
    }

}
