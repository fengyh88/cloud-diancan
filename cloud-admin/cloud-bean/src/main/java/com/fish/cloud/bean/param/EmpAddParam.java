package com.fish.cloud.bean.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel
@Data
public class EmpAddParam {
    @ApiModelProperty(value = "empId")
    private Long empId;

    @ApiModelProperty(value = "工号")
    private String empNumber;

    @ApiModelProperty(value = "姓名")
    private String empName;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "M(男) or F(女)")
    private String gender;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthDate;

    @ApiModelProperty(value = "头像图片路径")
    private String img;

    @ApiModelProperty(value = "所属部门Id")
    private Long deptId;

    @ApiModelProperty(value = "岗位Id")
    private Long dutyId;

    @ApiModelProperty(value = "角色Id")
    private Long roleId;
}
