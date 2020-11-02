package com.fish.cloud.common.util.wxPay;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class SignatureDTO {
    private String url;
    private String packageStr;
    private String appId;
    private String appSecret;
    private String out_trade_no;
    private String code;
    private String openId;
    private String timeStamp;
    private String nonceStr;
    private String signature;
    private String jsapi_ticket;
}
