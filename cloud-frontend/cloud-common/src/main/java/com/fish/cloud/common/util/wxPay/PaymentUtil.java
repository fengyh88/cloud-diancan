package com.fish.cloud.common.util.wxPay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentUtil {

    public String getWechatAppIdMiniProgram() {
        try {
            return "wx1c6dc45433d7b321";
        }catch(Exception e) {
            log.error("获取支付参数发生异常: "+e.getMessage());
            return "";
        }
    }

    public String getWechatAppSecretMiniProgram() {
        try {
            return "eccc24fce6159c85103784087b87e640";
        }catch(Exception e) {
            log.error("获取支付参数发生异常: "+e.getMessage());
            return "";
        }
    }

    /**
     * 商品平台密钥
     * @return
     */
    public String getWechatApiKey() {
        try {
            return "lingniaoxinlingshou514906514906a";
        }catch(Exception e) {
            log.error("获取支付参数发生异常: "+e.getMessage());
            return "";
        }
    }

    public String getWechatMerchantId() {
        try {
            return "1550780571";
        }catch(Exception e) {
            log.error("获取支付参数发生异常: "+e.getMessage());
            return "";
        }
    }

    public String getWechatNotifyUrl() {
        try {
            return "https://www.linkeo.cloud:8443/api/wxPay/notify/order";
        }catch(Exception e) {
            log.error("获取支付参数发生异常: "+e.getMessage());
            return "";
        }
    }

    /**
     * 小程序通过code换取open id
     */
    public String getWechatOpenId() {
        return "https://api.weixin.qq.com/sns/jscode2session?appid="+getWechatAppIdMiniProgram()+"&secret="+getWechatAppSecretMiniProgram()+"&js_code="+"CODE"+"&grant_type=authorization_code";
    }

    public String getDomainName() {
        try {
            return "https://www.linkeo.cloud:8443";
        }catch(Exception e) {
            log.error("获取支付参数发生异常: "+e.getMessage());
            return "";
        }
    }
}
