package com.fish.cloud.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.config.ConstConf;
import com.fish.cloud.bean.model.Order;
import com.fish.cloud.bean.model.OrderSettlement;
import com.fish.cloud.bean.model.User;
import com.fish.cloud.bean.param.OrderPayOnlineParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.ArithUtil;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.common.util.IpHelper;
import com.fish.cloud.common.util.wxPay.*;
import com.fish.cloud.service.IOrderService;
import com.fish.cloud.service.IOrderSettlementService;
import com.fish.cloud.service.IPayService;
import com.fish.cloud.service.IUserService;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

/**
 * <p>
 * 支付
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class PayServiceImpl implements IPayService {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IOrderSettlementService orderSettlementService;
    @Autowired
    private IUserService userService;
    @Autowired
    private Snowflake snowflake;
    @Autowired
    private PaymentUtil paymentUtil;
    @Autowired
    private WechatUtil wechatUtil;
    @Autowired
    private WXJSAPISDKUtility wxjsapisdkUtility;

    // private WxPayServiceImpl wxPayService = new WxPayServiceImpl();

    /**
     * 微信支付
     * @param orderPayOnlineParam
     * @return
     */
    @Transactional
    @Override
    public TupleRet<WxPayMpOrderResult> wx(OrderPayOnlineParam orderPayOnlineParam) {
        var order = orderService.getById(orderPayOnlineParam.getId());
        if (ObjectUtils.isEmpty(order)) {
            return TupleRet.failed("订单不存在");
        }

        // 0全部  1:待付款 2:已付款 3:已发货 4:已收货 5:已评价 6:已取消 （取消审核通过，不发货），7:已删除 回收站 8:已删除 永久删除 11:取消订单审核中
        // 状态判断，1:待付款
        switch (order.getStatus()){
            case 6:
                return TupleRet.failed("订单已取消");
            case 7:
            case 8:
                return TupleRet.failed("订单已删除");
            case 11:
                return TupleRet.failed("订单取消申请中");
            case 2:
                return TupleRet.failed("订单已付款");
            case 3:
                return TupleRet.failed("订单已发货");
            case 4:
            case 5:
                return TupleRet.failed("订单已完成");
        }

        // 写入订单结算表
        OrderSettlement orderSettlementE = orderSettlementService.getByOrderNumber(order.getOrderNumber());
        if (ObjectUtils.isEmpty(orderSettlementE)){
            // 如果不存在，则插入
            // 支付单号
            String payNumber = String.valueOf(snowflake.nextId());
            OrderSettlement orderSettlement = new OrderSettlement();
            orderSettlement.setOrderId(order.getOrderId());
            orderSettlement.setOrderNumber(order.getOrderNumber());
            orderSettlement.setPayType(order.getPayType());
            orderSettlement.setPayTypeName("微信支付");
            orderSettlement.setPayAmount(order.getActualAmount());
            orderSettlement.setPayNumber(payNumber);
            orderSettlement.setPayStatus(0); // 回调通知后更新
            orderSettlement.setBizPayNumber(""); // 回调通知后更新
            orderSettlement.setIsClear(0); // 未清算
            orderSettlement.setUserId(order.getUserId());
            orderSettlement.setShopId(order.getShopId());
            orderSettlement.setCreateTime(DateTimeUtil.getCurrentDateTime());
            try {
                orderSettlementService.save(orderSettlement);
                orderSettlementE = orderSettlement;
            } catch (Exception ex) {
                log.error(ex.getMessage());
                return TupleRet.failed(ex.getMessage());
            }
        }

        // 微信支付
        TupleRet ret = wxPay(order, orderSettlementE);
        return ret;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TupleRet<String> wxPaySuccess(String payNo, String bizPayNo) {
        var orderSettlement = orderSettlementService.getOne(new LambdaQueryWrapper<OrderSettlement>()
                .eq(OrderSettlement::getPayNumber, payNo));
        if (ObjectUtils.isEmpty(orderSettlement)){
            return TupleRet.failed("结算信息不存在");
        }

        // 订单结算信息已回调
        if (orderSettlement.getPayStatus() == 1) {
           return TupleRet.failed("结算信息已支付");
        }

        try {
            orderSettlement.setPayStatus(1);
            orderSettlement.setBizPayNumber(bizPayNo);
            orderSettlementService.updateById(orderSettlement);
        } catch (Exception ex){
            log.error(ex.getMessage());
            return TupleRet.failed("结算信息更改错误");
        }

        // 更新订单已支付
        Order order = orderService.getOne(new LambdaQueryWrapper<Order>()
                .eq(Order::getOrderNumber,orderSettlement.getOrderNumber()));
        if(ObjectUtils.isEmpty(order)){
            return TupleRet.failed("订单不存在");
        }

        try {
            order.setIsPayed(1);
            // 2:已付款
            order.setStatus(2);
            order.setPayTime(DateTimeUtil.getCurrentDateTime());
            orderService.updateById(order);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success(order.getOrderNumber());
    }

    /**
     * 微信支付
     * @param order)
     * @return
     */
    private TupleRet<SignatureDTO> wxPay(Order order, OrderSettlement orderSettlement){
        try {
            // 根据openId获取平台中用户信息
            User user = userService.getOne(new LambdaQueryWrapper<User>()
                    .eq(User::getUserId, order.getUserId()));
            if (ObjectUtils.isEmpty(user)){
                return TupleRet.failed("用户不存在");
            }
//            // openId
//            String openId = user.getWechatOpenId();
//            // 金额
//            Double payAmount = Double.parseDouble(orderSettlement.getPayAmount().toString());
//            WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
//            orderRequest.setBody(order.getProdName());
//            orderRequest.setOutTradeNo(orderSettlement.getPayNumber());
//            orderRequest.setTotalFee((int) ArithUtil.mul(payAmount, 100));
//            orderRequest.setSpbillCreateIp(IpHelper.getIpAddr());
//            orderRequest.setNotifyUrl(ConstConf.BASE_URL + "wxPay/notice/pay/order");
//            orderRequest.setTradeType(WxPayConstants.TradeType.JSAPI);
//            orderRequest.setOpenid(openId);
//
//            WxPayMpOrderResult wxPayMpOrderResult = wxPayService.createOrder(orderRequest);
//            return TupleRet.success(wxPayMpOrderResult);

            //初始化微信统一下单接口
            Double payAmount = Double.parseDouble(orderSettlement.getPayAmount().toString());
            String openId = user.getWechatOpenId();

            WechatPayRequest payRequest = new WechatPayRequest();
            payRequest.setAppid(paymentUtil.getWechatAppIdMiniProgram());
            payRequest.setMch_id(paymentUtil.getWechatMerchantId());
            payRequest.setNonce_str(RandomStringUtils.randomAlphanumeric(32));
            payRequest.setOpenid(openId);
            payRequest.setOut_trade_no(orderSettlement.getPayNumber());
            payRequest.setBody(WechatConstants.PRODUCT_NAME);
            payRequest.setTotal_fee((int) ArithUtil.mul(payAmount, 100));
            payRequest.setSpbill_create_ip("106.15.179.189");
            payRequest.setNotify_url(paymentUtil.getWechatNotifyUrl());
            payRequest.setTrade_type("JSAPI");
            payRequest.setAttach(WechatConstants.PRODUCT_NAME);
            payRequest.setProduct_id(WechatConstants.PRODUCT_ID);
            payRequest.setSign(wechatUtil.getSign(payRequest));
            String requestXML = wechatUtil.toXML(payRequest);
            requestXML = new String(requestXML.getBytes("utf-8"),"iso-8859-1");
            // requestXML = new String(requestXML.getBytes("utf-8"),"utf-8");
            log.info("Wechat unified order request: "+requestXML);
            //下单
            String wechatResponseStr = wechatUtil.postWechatUnifiedOrder(requestXML);
            log.info("Wechat unified order Response: "+wechatResponseStr);
            WechatPayResponse payResponse = (WechatPayResponse)wechatUtil.fromXML2WechatResponse(WechatPayResponse.class,wechatResponseStr);
            if("SUCCESS".equals(payResponse.getReturn_code()) && "SUCCESS".equals(payResponse.getResult_code())){

                SignatureDTO signatureDTO = wxjsapisdkUtility.getWXPaySignature(payResponse.getPrepay_id());
                signatureDTO.setOut_trade_no(payRequest.getOut_trade_no());
                return TupleRet.success(signatureDTO);
            }else{
                return TupleRet.failed("调用微信支付异常, 请稍后重试");
//                resultDTO.getBody().getStatus().setStatusCode(AuthenticationConstants.STATUS_CODE_ERROR);
//                resultDTO.getBody().getStatus().setErrorCode("1");
//                resultDTO.getBody().getStatus().setErrorDesc("调用微信支付异常, 请稍后重试");
            }

        } catch (WxPayException | UnsupportedEncodingException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return TupleRet.failed(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return TupleRet.failed(e.getMessage());
        }
    }

    private TupleRet<WxPayMpOrderResult> wxPayBackup(Order order, OrderSettlement orderSettlement){
//        try {
//            // 根据openId获取平台中用户信息
//            User user = userService.getOne(new LambdaQueryWrapper<User>()
//                    .eq(User::getUserId, order.getUserId()));
//            if (ObjectUtils.isEmpty(user)){
//                return TupleRet.failed("用户不存在");
//            }
//            // openId
//            String openId = user.getWechatOpenId();
//            // 金额
//            Double payAmount = Double.parseDouble(orderSettlement.getPayAmount().toString());
//            WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
//            orderRequest.setBody(order.getProdName());
//            orderRequest.setOutTradeNo(orderSettlement.getPayNumber());
//            orderRequest.setTotalFee((int) ArithUtil.mul(payAmount, 100));
//            orderRequest.setSpbillCreateIp(IpHelper.getIpAddr());
//            orderRequest.setNotifyUrl(ConstConf.BASE_URL + "wxPay/notice/pay/order");
//            orderRequest.setTradeType(WxPayConstants.TradeType.JSAPI);
//            orderRequest.setOpenid(openId);
//
//            WxPayMpOrderResult wxPayMpOrderResult = wxPayService.createOrder(orderRequest);
//            return TupleRet.success(wxPayMpOrderResult);
//        } catch (WxPayException e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//            return TupleRet.failed(e.getMessage());
//        }
        return null;
    }
}
