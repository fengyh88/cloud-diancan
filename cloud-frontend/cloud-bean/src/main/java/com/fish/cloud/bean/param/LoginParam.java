package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class LoginParam {
    @ApiModelProperty(value = "店铺Id")
    private Long shopId;
    @ApiModelProperty(value = "台桌Id")
    private Long tableId;
    @ApiModelProperty(name = "工号或手机号")
    private String userName;
    @ApiModelProperty(name = "密码")
    private String password;
}
