package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.model.Perm;
import com.fish.cloud.bean.param.OrderPayOnlineParam;
import com.fish.cloud.common.ret.TupleRet;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;

import java.util.List;

/**
 * <p>
 * 支付
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IPayService {
    /**
     * 微信支付
     * @param orderPayOnlineParam
     * @return
     */
    TupleRet<WxPayMpOrderResult> wx(OrderPayOnlineParam orderPayOnlineParam);

    /**
     * 支付成功后回调
     * @param payNo
     * @param bizPayNo
     * @return
     */
    TupleRet<String> wxPaySuccess(String payNo, String bizPayNo);
}
