package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel
@Data
public class ProdParam {
    @ApiModelProperty(value = "商品类目")
    private String cateId;
    @ApiModelProperty(value = "关键字")
    private String keyword;
}