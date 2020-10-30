package com.fish.cloud.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class ProdAttrDto {

    @ApiModelProperty(value = "名称")
    private String attrName;

    @ApiModelProperty(value = "值")
    private String attrValue;
}
