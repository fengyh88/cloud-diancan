package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class UserPwdParam {
    @ApiModelProperty(name = "原密码")
    private String oldPwd;
    @ApiModelProperty(name = "新密码")
    private String newPwd;
    @ApiModelProperty(name = "重复新密码")
    private String newPwd2;
}
