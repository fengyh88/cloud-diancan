package com.fish.cloud.api.controller;

import com.fish.cloud.bean.dto.OrderItemDto;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IOrderItemService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
