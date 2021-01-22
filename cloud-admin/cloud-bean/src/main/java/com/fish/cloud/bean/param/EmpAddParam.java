package com.fish.cloud.bean.param;

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

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "M(男) or F(女)")
    private String gender;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthDate;

    @ApiModelProperty(value = "角色Id")
    private Long roleId;
}
