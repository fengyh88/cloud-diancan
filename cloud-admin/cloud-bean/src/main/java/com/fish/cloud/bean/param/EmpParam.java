package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel
@Data
public class EmpParam {
    @ApiModelProperty(value = "关键字 工号/姓名/邮箱/手机号")
    private String keywords;
    @ApiModelProperty(value = "所属部门Id")
    private Long deptId;
    @ApiModelProperty(value = "岗位Id")
    private Long dutyId;
    @ApiModelProperty(value = "角色Id")
    private Long roleId;
}
