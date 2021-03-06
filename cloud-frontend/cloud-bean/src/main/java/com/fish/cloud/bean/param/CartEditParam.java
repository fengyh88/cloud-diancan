package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class CartEditParam {
    @ApiModelProperty(name = "cartId")
    private Long cartId;
    @ApiModelProperty(name = "商品Id")
    private Long prodId;
    @ApiModelProperty(name = "skuId")
    private String skuId;
    @ApiModelProperty(name = "商品数量")
    private Integer num;
}
