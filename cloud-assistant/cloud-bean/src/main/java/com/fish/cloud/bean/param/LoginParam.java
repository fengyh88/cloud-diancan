package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class LoginParam {
    @ApiModelProperty(name = "工号")
    private String userNumber;
    @ApiModelProperty(name = "密码")
    private String password;
}
