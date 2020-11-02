package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel
@Data
public class EmpMyParam {

    @ApiModelProperty(value = "姓名")
    private String empName;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "M(男) or F(女)")
    private String gender;

    @ApiModelProperty(value = "出生日期，例如：2009-11-27")
    private Date birthDate;
}
