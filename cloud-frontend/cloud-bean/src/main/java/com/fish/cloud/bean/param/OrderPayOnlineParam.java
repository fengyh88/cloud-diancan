package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class OrderPayOnlineParam {
    @ApiModelProperty(value = "订单Id")
    private Long id;
    @ApiModelProperty("1微信支付 2支付宝支付")
    private Integer payType;
}
