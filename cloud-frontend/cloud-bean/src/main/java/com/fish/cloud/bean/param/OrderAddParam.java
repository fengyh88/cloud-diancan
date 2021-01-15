package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@ApiModel
@Data
public class OrderAddParam {
    @ApiModelProperty(name = "订单总费用(包含运费)")
    private BigDecimal totalAmount;

    @ApiModelProperty(name = "实际支付总费用(含运费)")
    private BigDecimal actualAmount;

    @ApiModelProperty(name = "优惠金额")
    private BigDecimal reduceAmount;

    @ApiModelProperty(name = "订单备注")
    private String remark;

    @ApiModelProperty(name = "订单明细列表")
    private List<OrderAddItemParam> items;
}
