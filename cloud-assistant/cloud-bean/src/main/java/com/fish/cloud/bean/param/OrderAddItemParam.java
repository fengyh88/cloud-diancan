package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description
 * @Author fengyh
 * @Date 2020/3/8 23:22
 * @Version 1.0
 */
@Data
public class OrderAddItemParam {
    @ApiModelProperty(name = "商品Id")
    private long goodsId;
    @ApiModelProperty(name = "商品数量")
    private long num;
    @ApiModelProperty(name = "此商品的总价")
    private BigDecimal totalPrice;
    @ApiModelProperty(name = "商品规格")
    private String attr;
    @ApiModelProperty(name = "商品规格图片")
    private String pic;
}
