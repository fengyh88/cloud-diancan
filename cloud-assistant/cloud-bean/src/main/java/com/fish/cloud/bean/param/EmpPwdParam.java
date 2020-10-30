package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EmpPwdParam {
    @ApiModelProperty(name = "")
    private String oldPwd;
    @ApiModelProperty(name = "")
    private String newPwd;
    @ApiModelProperty(name = "")
    private String newPwd2;
}
