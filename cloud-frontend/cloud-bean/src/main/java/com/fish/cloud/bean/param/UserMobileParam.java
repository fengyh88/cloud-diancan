package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class UserMobileParam {
    @ApiModelProperty(name = "id")
    private String userId;
    @ApiModelProperty(name = "手机号")
    private String mobile;
}
