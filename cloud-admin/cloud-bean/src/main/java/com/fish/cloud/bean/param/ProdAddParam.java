package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@ApiModel
@Data
public class ProdAddParam {

    @ApiModelProperty(value = "商品编码")
    private String prodCode;

    @ApiModelProperty(value = "商品名称")
    private String prodName;

    @ApiModelProperty(value = "商品分类")
    private Long cateId;

    @ApiModelProperty(value = "原价")
    private BigDecimal oriPrice;

    @ApiModelProperty(value = "现价")
    private BigDecimal price;

    @ApiModelProperty(value = "会员价")
    private BigDecimal memPrice;

    @ApiModelProperty(value = "单位")
    private String unitId;

    @ApiModelProperty(value = "简要描述,卖点等")
    private String brief;

    @ApiModelProperty(value = "详细描述")
    private String content;
}
