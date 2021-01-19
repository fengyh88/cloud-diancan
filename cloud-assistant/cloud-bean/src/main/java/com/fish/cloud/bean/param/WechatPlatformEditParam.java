package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class WechatPlatformEditParam {

    private Long id;

    /**
     * 描述
     */
    private String des;
    /**
     * 微信公众号Id
     */
    private String wechatPlatformId;
    /**
     * 微信小程序Id
     */
    private String wechatAppId;
    /**
     * 微信小程序secretkey
     */
    private String wechatSecretKey;
}
