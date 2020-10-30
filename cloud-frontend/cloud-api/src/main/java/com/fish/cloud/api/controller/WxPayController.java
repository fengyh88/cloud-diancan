package com.fish.cloud.api.controller;

import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.wxPay.WechatPayResult;
import com.fish.cloud.common.util.wxPay.WechatUtil;
import com.fish.cloud.service.IPayService;
import com.github.binarywang.wxpay.bean.coupon.*;
import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxPayRefundNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxScanPayNotifyResult;
import com.github.binarywang.wxpay.bean.request.*;
import com.github.binarywang.wxpay.bean.result.*;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Api("微信支付回调")
@RestController
@RequestMapping("/wxPay")
@AllArgsConstructor
@Slf4j
public class WxPayController {
    //private WxPayService wxService;
    @Autowired
    private WechatUtil wechatUtil;
    @Autowired
    private IPayService payService;

//    @ApiOperation(value = "支付回调通知处理")
//    @PostMapping("/notify/order")
//    public ApiResult<String> parseOrderNotifyResult(@RequestBody String xmlData) throws WxPayException {
//        final WxPayOrderNotifyResult notifyResult = this.wxService.parseOrderNotifyResult(xmlData);
//        String payNo = notifyResult.getOutTradeNo();
//        String bizPayNo = notifyResult.getTransactionId();
//        // 根据内部订单号更新order settlement
//        var ret = payService.wxPaySuccess(payNo, bizPayNo);
//        return ApiResult.fromTupleRet(ret);
//    }

    @ApiOperation(value = "支付回调通知处理")
    @PostMapping("/notify/order")
    public ApiResult wechatPayResponse(HttpServletRequest request, HttpServletResponse response) {
        int length = request.getContentLength();
        byte[] bytes = new byte[length];
        InputStream inputStream;
        try {
            inputStream = request.getInputStream();
            inputStream.read(bytes);
            String responseStr = new String(bytes, "UTF-8");
            log.info("Wechat Pay Callback: "+ responseStr);

            WechatPayResult payResultResponse = (WechatPayResult) wechatUtil.fromXML2WechatResult(WechatPayResult.class, responseStr, "xml");
            if ("SUCCESS".equals(payResultResponse.getReturn_code()) && "SUCCESS".equals(payResultResponse.getResult_code())) {
                String payNo = payResultResponse.getOut_trade_no();
                String bizPayNo = payResultResponse.getTransaction_id();
                // 根据内部订单号更新order settlement
                var ret = payService.wxPaySuccess(payNo, bizPayNo);
                return ApiResult.fromTupleRet(ret);
            } else {
                return ApiResult.failed(payResultResponse.getReturn_msg());
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }

    @ApiOperation(value = "退款回调通知处理")
    @PostMapping("/notify/refund")
    public String parseRefundNotifyResult(@RequestBody String xmlData) throws WxPayException {
        // final WxPayRefundNotifyResult result = this.wxService.parseRefundNotifyResult(xmlData);
        // TODO 根据自己业务场景需要构造返回对象
        return WxPayNotifyResponse.success("成功");
    }

    @ApiOperation(value = "扫码支付回调通知处理")
    @PostMapping("/notify/scanpay")
    public String parseScanPayNotifyResult(String xmlData) throws WxPayException {
        // final WxScanPayNotifyResult result = this.wxService.parseScanPayNotifyResult(xmlData);
        // TODO 根据自己业务场景需要构造返回对象
        return WxPayNotifyResponse.success("成功");
    }
}
