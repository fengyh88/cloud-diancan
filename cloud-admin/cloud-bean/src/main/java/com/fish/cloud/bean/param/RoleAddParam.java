package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class RoleAddParam {

    @ApiModelProperty(value = "Id")
    private Long roleId;

    @ApiModelProperty(value = "编码")
    private String roleCode;

    @ApiModelProperty(value = "名称")
    private String roleName;

    @ApiModelProperty(value = "备注")
    private String remark;
}
