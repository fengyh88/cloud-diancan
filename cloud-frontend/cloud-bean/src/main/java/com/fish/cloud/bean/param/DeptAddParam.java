package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class DeptAddParam {
    @ApiModelProperty(value = "部门Id")
    private Long deptId;

    @ApiModelProperty(value = "名称")
    private String deptName;

    @ApiModelProperty(value = "父级部门")
    private String pId;
}
