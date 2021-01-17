package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class UserMyParam {

    @ApiModelProperty(value = "用户名")
    private Long userId;
}
