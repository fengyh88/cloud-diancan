package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class LoginParam {
    @ApiModelProperty(value = "店铺Id")
    private String shopId;
    @ApiModelProperty(name = "工号或手机号")
    private String userNumber;
    @ApiModelProperty(name = "密码")
    private String password;
}
