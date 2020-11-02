package com.fish.cloud.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel
@Data
public class EmpDto {
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
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "出生日期 例如：2009-11-27")
    private Date birthDate;

    @ApiModelProperty(value = "头像图片路径")
    private String pic;

    @ApiModelProperty(value = "所在店铺Id")
    private Long shopId;

    @ApiModelProperty(value = "所属部门Id")
    private Long deptId;

    @ApiModelProperty(value = "岗位Id")
    private Long dutyId;

    @ApiModelProperty(value = "角色Id")
    private Long roleId;

    @ApiModelProperty(value = "状态  -1删除 0禁用 1启用")
    private Integer status;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "岗位名称")
    private String dutyName;

    @ApiModelProperty(value = "角色名称")
    private String roleName;
}
