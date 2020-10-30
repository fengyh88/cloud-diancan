package com.fish.cloud.common.util.wxPay;

import lombok.Data;

@Data
public class WechatPayResponse {
    private String appid;
    private String mch_id;
    private String device_info;
    private String nonce_str;
    private String timestamp;
    private String sign;
    private String trade_type;
    private String return_code;
    private String return_msg;
    private String result_code;
    private String err_code;

    private String err_code_des;
    private String prepay_id;
    private String code_url;
}
