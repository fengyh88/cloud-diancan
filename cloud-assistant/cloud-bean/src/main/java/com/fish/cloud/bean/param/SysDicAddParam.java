package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class SysDicAddParam {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "编码")
    private String dicCode;

    @ApiModelProperty(value = "名称")
    private String dicName;

    @ApiModelProperty(value = "备注")
    private String remark;
}
