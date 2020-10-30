package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class SysConfigEditParam {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "value")
    private String paramValue;

    @ApiModelProperty(value = "备注")
    private String remark;
}
