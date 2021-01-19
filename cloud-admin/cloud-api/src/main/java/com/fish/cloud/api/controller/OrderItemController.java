package com.fish.cloud.api.controller;

import com.fish.cloud.bean.dto.OrderItemDto;
import com.fish.cloud.bean.param.OrderCompleteParam;
import com.fish.cloud.bean.param.OrderItemUpParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IOrderItemService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 订单项
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Controller
@RequestMapping("/order/item")
public class OrderItemController {

    @Autowired
    private IOrderItemService orderItemService;

    @ApiOperation("根据状态查询列表")
    @ApiImplicitParam(name = "listByOrderId", value = "订单Id", required = true)
    @RequestMapping(value = "/listByOrderId")
    public ApiResult<List<OrderItemDto>> listByOrderId(@RequestParam Long orderId) {
       var dtoList = orderItemService.listByOrderId(orderId);
        return ApiResult.success(dtoList);
    }

    @ApiOperation("出餐")
    @ApiImplicitParam(name = "orderItemUpParam", value = "明细", required = true)
    @PostMapping(value = "/up")
    public ApiResult up(@RequestBody OrderItemUpParam orderItemUpParam) {
        var ret = orderItemService.status(orderItemUpParam.getOrderItemId(),2); // 2表示出餐
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("删除")
    @ApiImplicitParam(name = "orderItemUpParam", value = "明细", required = true)
    @PostMapping(value = "/del")
    public ApiResult del(@RequestBody OrderItemUpParam orderItemUpParam) {
        var ret = orderItemService.status(orderItemUpParam.getOrderItemId(),-1); // -1表示删除
        return ApiResult.fromTupleRet(ret);
    }
}
