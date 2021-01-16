package com.fish.cloud.api.controller;

import com.fish.cloud.bean.param.CartEditParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IOrderItemService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 订单项
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Controller
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private IOrderItemService orderItemService;

    @ApiOperation("删除")
    @ApiImplicitParam(name = "orderItemId", value = "明细Id", required = true)
    @GetMapping(value = "/delete")
    public ApiResult delete(@RequestParam Long orderItemId) {
        orderItemService.deleteByOrderItemId(orderItemId);
        return ApiResult.success();
    }
}
