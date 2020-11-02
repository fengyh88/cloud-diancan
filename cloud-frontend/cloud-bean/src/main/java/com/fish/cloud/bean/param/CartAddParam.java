package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CartAddParam {
    @ApiModelProperty(name = "商品Id")
    private Long prodId;
    @ApiModelProperty(name = "商品数量")
    private Integer num;
    @ApiModelProperty(name = "规格")
    private String skuId;
}
