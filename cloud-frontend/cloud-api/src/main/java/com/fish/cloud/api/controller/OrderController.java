package com.fish.cloud.api.controller;

import com.fish.cloud.bean.dto.OrderDetailDto;
import com.fish.cloud.bean.dto.OrderDto;
import com.fish.cloud.bean.param.OrderAddParam;
import com.fish.cloud.bean.param.OrderBySatusParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "订单")
@Controller
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @ApiOperation("根据状态查询列表")
    @ApiImplicitParam(name = "orderBySatusParam", value = "根据状态查询参数", required = true)
    @PostMapping(value = "/listByStatus")
    public ApiResult<List<OrderDto>> listByStatus(@RequestBody OrderBySatusParam orderBySatusParam) {
        if (!ArrayUtils.contains(new int[]{0, 1, 9, 13, 17}, orderBySatusParam.getStatus())) {
            return ApiResult.failed("订单状态错误");
        }
        var dtoList = orderService.listByStatus(orderBySatusParam);
        return ApiResult.success(dtoList);
    }

    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "id", required = true)
    @GetMapping(value = "/detail")
    public ApiResult<OrderDetailDto> detail(@RequestParam(value = "id") long id) {
        var dto = orderService.detail(id);
        return ApiResult.success(dto);
    }

    @ApiOperation("订单提交")
    @ApiImplicitParam(name = "orderAddParam", value = "订单提交信息", required = true)
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ApiResult<Long> submit(@RequestBody OrderAddParam orderAddParam) {
        var ret = orderService.submit(orderAddParam);
        return ApiResult.fromTupleRet(ret);
    }
}
