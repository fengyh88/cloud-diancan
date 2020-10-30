package com.fish.cloud.api.controller;

import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.dto.OrderCountStatusDto;
import com.fish.cloud.bean.dto.OrderDetailDto;
import com.fish.cloud.bean.dto.OrderDto;
import com.fish.cloud.bean.param.OrderBySatusParam;
import com.fish.cloud.bean.param.OrderSendParam;
import com.fish.cloud.common.ret.ApiResult;
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
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @ApiOperation("根据状态查询列表")
    @ApiImplicitParam(name = "orderBySatusParam", value = "根据状态查询参数", required = true)
    @PostMapping(value = "/listByStatus")
    public ApiResult<List<OrderDto>> listByStatus(@RequestBody OrderBySatusParam orderBySatusParam) {
        if (!ArrayUtils.contains(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 11}, orderBySatusParam.getStatus())) {
            return ApiResult.failed("订单状态错误");
        }
        var dtos = orderService.listByStatus(ApiContextHolder.getAuthDto().getShopId(), orderBySatusParam);
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
        var dto = orderService.countOrderStatus(ApiContextHolder.getAuthDto().getShopId());
        return ApiResult.success(dto);
    }

    @ApiOperation("通过取消申请")
    @ApiImplicitParam(name = "id", value = "id", required = true)
    @GetMapping(value = "/cancelPass")
    public ApiResult cancelPass(@RequestParam(value = "id") Long id) {
        var ret = orderService.cancelPass(id);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("发货")
    @ApiImplicitParam(name = "orderSendParam", value = "发货信息", required = true)
    @PostMapping(value = "/send")
    public ApiResult send(@RequestBody OrderSendParam orderSendParam) {
        var ret = orderService.send(orderSendParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("确定不发货，取消订单")
    @ApiImplicitParam(name = "id", value = "id", required = true)
    @GetMapping(value = "/notSend")
    public ApiResult notSend(@RequestParam(value = "id") Long id) {
        var ret = orderService.notSend(id);
        return ApiResult.fromTupleRet(ret);
    }

}
