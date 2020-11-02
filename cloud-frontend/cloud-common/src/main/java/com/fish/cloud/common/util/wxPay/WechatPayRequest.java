package com.fish.cloud.common.util.wxPay;

import lombok.Data;

@Data
public class WechatPayRequest {
    private String appid;
    private String attach;
    private String body;
    private String detail;
    private String device_info;
    private String fee_type;
    private String goods_tag;
    private String limit_pay;
    private String mch_id;
    private String nonce_str;
    private String notify_url;

    private String out_trade_no;
    private String product_id;
    private String spbill_create_ip;
    private String time_expire;
    private String time_start;
    private int total_fee;
    private String trade_type;
    private String openid;
    private String sign;
}
