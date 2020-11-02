package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserLoginWxParam {
    @ApiModelProperty(name = "")
    private String code;
    @ApiModelProperty(name = "")
    private String encryptedData;
    @ApiModelProperty(name = "")
    private String iv;
    @ApiModelProperty(name = "")
    private String signature;
}
