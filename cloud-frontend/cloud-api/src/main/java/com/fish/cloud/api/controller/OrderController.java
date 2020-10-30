package com.fish.cloud.api.controller;

import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.dto.OrderCountStatusDto;
import com.fish.cloud.bean.dto.OrderDetailDto;
import com.fish.cloud.bean.dto.OrderDto;
import com.fish.cloud.bean.model.Order;
import com.fish.cloud.bean.param.OrderAddParam;
import com.fish.cloud.bean.param.OrderBySatusParam;
import com.fish.cloud.bean.param.OrderCancelParam;
import com.fish.cloud.bean.param.OrderPayOnlineParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "订单")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @ApiOperation("根据状态查询列表")
    @ApiImplicitParam(name = "orderBySatusParam", value = "根据状态查询参数", required = true)
    @PostMapping(value = "/listByStatus")
    public ApiResult<List<OrderDto>> listByStatus(@RequestBody OrderBySatusParam orderBySatusParam) {
        if (!ArrayUtils.contains(new int[]{0, 1, 2, 3, 4, 6}, orderBySatusParam.getStatus())) {
            return ApiResult.failed("未设置查询的订单状态或者订单状态设置错误");
        }
        var dtos = orderService.listByStatus(ApiContextHolder.getShopId(), ApiContextHolder.getAuthDto().getUserId(), orderBySatusParam);
        return ApiResult.success(dtos);
    }

    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "id", required = true)
    @GetMapping(value = "/detail")
    public ApiResult<OrderDetailDto> detail(@RequestParam(value = "id") long id) {
        var dto = orderService.detail(id);
        return ApiResult.success(dto);
    }

    @ApiOperation("统计订单各个状态数量")
    @GetMapping(value = "/countOrderStatus")
    public ApiResult<OrderCountStatusDto> countOrderStatus() {
        var dto = orderService.countOrderStatus(ApiContextHolder.getShopId(), ApiContextHolder.getAuthDto().getUserId());
        return ApiResult.success(dto);
    }

    @ApiOperation("确认收货")
    @ApiImplicitParam(name = "id", value = "id", required = true)
    @GetMapping(value = "/confirm")
    public TupleRet confirm(@RequestParam(value = "id") Long id) {
        return orderService.confirm(id);
    }

    @ApiOperation("取消订单。待付款时、待发货、待收货时可取消订单")
    @ApiImplicitParam(name = "orderCancelParam", value = "取消订单信息", required = true)
    @PostMapping(value = "/cancel")
    public ApiResult cancel(@RequestBody OrderCancelParam orderCancelParam) {
        var ret = orderService.cancel(orderCancelParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("删除订单。已完成时可删除订单")
    @ApiImplicitParam(name = "id", value = "id", required = true)
    @GetMapping(value = "/delete")
    public ApiResult delete(@RequestParam("id") Long id) {
        var ret = orderService.delete(id);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("订单提交")
    @ApiImplicitParam(name = "orderAddParam", value = "订单提交信息", required = true)
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ApiResult<Long> submit(@RequestBody OrderAddParam orderAddParam) {
        var ret = orderService.submit(ApiContextHolder.getShopId(), ApiContextHolder.getAuthDto().getUserId(), orderAddParam);
        return ApiResult.fromTupleRet(ret);
    }

}
