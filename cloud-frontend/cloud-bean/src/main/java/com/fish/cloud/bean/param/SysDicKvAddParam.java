package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class SysDicKvAddParam {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "字典编码")
    private String dicCode;

    @ApiModelProperty(value = "key")
    private String key;

    @ApiModelProperty(value = "value")
    private String value;

    @ApiModelProperty(value = "备注")
    private String remark;
}
