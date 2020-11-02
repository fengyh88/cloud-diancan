package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class UserLoginWxParam {
    @ApiModelProperty(value = "code")
    private String code;
    @ApiModelProperty(value = "encryptedData")
    private String encryptedData;
    @ApiModelProperty(value = "iv")
    private String iv;
    @ApiModelProperty(value = "signature")
    private String signature;

    // 另外一种方式获取微信信息
    @ApiModelProperty(value = "nickName")
    private String nickName;
    @ApiModelProperty(value = "gender")
    private String gender;
    @ApiModelProperty(value = "city")
    private String city;
    @ApiModelProperty(value = "province")
    private String province;
    @ApiModelProperty(value = "country")
    private String country;
    @ApiModelProperty(value = "avatarUrl")
    private String avatarUrl;
    @ApiModelProperty(value = "unionId")
    private String unionId;
}
