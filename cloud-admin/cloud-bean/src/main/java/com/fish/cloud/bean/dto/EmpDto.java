package com.fish.cloud.bean.dto;

import com.fish.cloud.bean.annotation.Dic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel
@Data
public class EmpDto implements IDtoDic {
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

    @ApiModelProperty(value = "出生日期 例如：2009-11-27")
    private Date birthDate;

    @ApiModelProperty(value = "所在店铺Id")
    private Long shopId;

    @ApiModelProperty(value = "角色Id")
    private Long roleId;

    @ApiModelProperty(value = "角色文本")
    private String roleText;

    @ApiModelProperty(value = "状态  -1删除 0禁用 1启用")
    private Integer status;

}
