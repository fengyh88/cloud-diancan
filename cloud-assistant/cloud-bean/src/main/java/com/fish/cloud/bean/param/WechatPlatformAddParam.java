package com.fish.cloud.bean.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel
@Data
public class WechatPlatformAddParam {

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
