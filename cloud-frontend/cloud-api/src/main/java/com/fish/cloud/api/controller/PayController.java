package com.fish.cloud.api.controller;

import com.fish.cloud.bean.param.OrderPayOnlineParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IPayService;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 支付
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "支付")
@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private IPayService payService;

    @ApiOperation("微信支付")
    @ApiImplicitParam(name = "orderBySatusParam", value = "订单支付信息", required = true)
    @PostMapping(value = "/wx")
    public ApiResult<WxPayMpOrderResult> wx(@RequestBody OrderPayOnlineParam orderPayOnlineParam) {
        if (!ArrayUtils.contains(new int[]{1}, orderPayOnlineParam.getPayType())) {
            return ApiResult.failed("支付类型错误");
        }
        var ret = payService.wx(orderPayOnlineParam);
        return ApiResult.fromTupleRet(ret);
    }
}
