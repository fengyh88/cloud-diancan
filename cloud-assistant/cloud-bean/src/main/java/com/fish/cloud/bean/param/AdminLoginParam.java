package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AdminLoginParam {
    @ApiModelProperty(name = "")
    private String userNumber;
    @ApiModelProperty(name = "")
    private String password;
}
