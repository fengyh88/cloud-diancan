package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description
 * @Author fengyh
 * @Date 2020/3/8 23:20
 * @Version 1.0
 */
@Data
public class OrderAddParam {
    @ApiModelProperty(name = "订单总费用(包含运费)")
    private BigDecimal totalAmount;
    @ApiModelProperty(name = "实际支付总费用(含运费)")
    private BigDecimal actualAmount;
    @ApiModelProperty(name = "运费")
    private BigDecimal dvyAmount;
    @ApiModelProperty(name = "用户收货地址")
    private Long userAddrId;
    @ApiModelProperty(name = "订单备注")
    private String remark;

    @ApiModelProperty(name = "订单明细列表")
    private List<OrderAddItemParam> items;
}
