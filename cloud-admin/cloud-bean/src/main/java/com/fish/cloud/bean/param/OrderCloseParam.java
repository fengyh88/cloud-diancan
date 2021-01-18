package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class OrderCloseParam {
    @ApiModelProperty(value = "订单Id")
    private Long orderId;
}
