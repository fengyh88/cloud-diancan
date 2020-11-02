package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@ApiModel
@Data
public class OrderSendParam {
    @ApiModelProperty(value = "订单Id")
    private Long orderId;

    @ApiModelProperty(value = "订单流水号")
    private String orderNumber;

    @ApiModelProperty(value = "配送类型")
    private String dvyType;

    @ApiModelProperty(value = "配送方式Id")
    private Long dvyId;

    @ApiModelProperty(value = "物流单号")
    private String dvyNumber;
}
