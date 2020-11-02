package com.fish.cloud.common.util.wxPay;

import lombok.Data;

@Data
public class WechatPayResult {

    private String appid;
    private String mch_id;
    private String device_info;
    private String nonce_str;
    private String sub_mch_id;
    private String sign;
    private String trade_type;
    private String return_code;
    private String return_msg;
    private String result_code;
    private String err_code;
    private String err_code_des;
    private String openid;
    private String is_subscribe;
    private String bank_type;
    private int total_fee;
    private String fee_type;
    private int cash_fee;
    private String cash_fee_type;
    private String transaction_id;
    private String out_trade_no;
    private String attach;
    private String time_end;
}
