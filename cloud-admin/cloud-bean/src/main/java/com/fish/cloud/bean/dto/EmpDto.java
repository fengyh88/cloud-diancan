package com.fish.cloud.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fish.cloud.bean.annotation.Dic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel
@Data
public class EmpDto extends DtoDic{
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

    @ApiModelProperty(value = "出生日期 例如：2009-11-27")
    private Date birthDate;

    @ApiModelProperty(value = "头像图片路径")
    private String pic;

    @ApiModelProperty(value = "所在店铺Id")
    private Long shopId;

    @ApiModelProperty(value = "所属部门Id")
    @Dic(dicCode = "dept_id",dicTable = "cloud_dept",dicText = "dept_name")
    private Long deptId;

    @ApiModelProperty(value = "岗位Id")
    @Dic(dicCode = "duty_id",dicTable = "cloud_duty",dicText = "duty_name")
    private Long dutyId;

    @ApiModelProperty(value = "角色Id")
    @Dic(dicCode = "role_id",dicTable = "cloud_role",dicText = "role_name")
    private Long roleId;

    @ApiModelProperty(value = "状态  -1删除 0禁用 1启用")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
