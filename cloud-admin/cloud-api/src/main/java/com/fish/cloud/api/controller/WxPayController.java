package com.fish.cloud.api.controller;

import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxPayRefundNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxScanPayNotifyResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("微信支付")
@RestController
@RequestMapping("api/wxPay")
@AllArgsConstructor
public class WxPayController {
    private WxPayService wxService;

    @ApiOperation(value = "支付回调通知处理")
    @PostMapping("/notify/order")
    public String parseOrderNotifyResult(@RequestBody String xmlData) throws WxPayException {
        final WxPayOrderNotifyResult notifyResult = this.wxService.parseOrderNotifyResult(xmlData);
        // TODO 根据自己业务场景需要构造返回对象
        return WxPayNotifyResponse.success("成功");
    }

    @ApiOperation(value = "退款回调通知处理")
    @PostMapping("/notify/refund")
    public String parseRefundNotifyResult(@RequestBody String xmlData) throws WxPayException {
        final WxPayRefundNotifyResult result = this.wxService.parseRefundNotifyResult(xmlData);
        // TODO 根据自己业务场景需要构造返回对象
        return WxPayNotifyResponse.success("成功");
    }

    @ApiOperation(value = "扫码支付回调通知处理")
    @PostMapping("/notify/scanpay")
    public String parseScanPayNotifyResult(String xmlData) throws WxPayException {
        final WxScanPayNotifyResult result = this.wxService.parseScanPayNotifyResult(xmlData);
        // TODO 根据自己业务场景需要构造返回对象
        return WxPayNotifyResponse.success("成功");
    }
}
