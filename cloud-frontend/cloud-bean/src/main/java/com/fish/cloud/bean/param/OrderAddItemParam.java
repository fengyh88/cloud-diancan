package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@ApiModel
@Data
public class OrderAddItemParam {
    @ApiModelProperty(name = "商品Id")
    private Long prodId;
    @ApiModelProperty(name = "商品名称")
    private String prodName;
    @ApiModelProperty(name = "商品图片")
    private String prodImg;
    @ApiModelProperty(name = "skuId")
    private Long skuId;
    @ApiModelProperty(name = "sku名称")
    private String skuName;
    @ApiModelProperty(name = "sku图片")
    private String skuImg;
    @ApiModelProperty(name = "商品数量")
    private Integer num;
    @ApiModelProperty(name = "单价")
    private BigDecimal price;
    @ApiModelProperty(name = "此商品的总价")
    private BigDecimal totalAmount;
}
