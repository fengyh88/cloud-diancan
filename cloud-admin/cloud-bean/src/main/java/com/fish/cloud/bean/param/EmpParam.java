package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class EmpParam {
    @ApiModelProperty(value = "关键字 工号/姓名/手机号")
    private String keywords;
    @ApiModelProperty(value = "角色Id")
    private Long roleId;
}
