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
    private BigDecimal totalPrice;
    @ApiModelProperty(name = "实际支付总费用(含运费)")
    private BigDecimal payPrice;
    @ApiModelProperty(name = "运费")
    private BigDecimal expressPrice;
    @ApiModelProperty(name = "收货人姓名")
    private String name;
    @ApiModelProperty(name = "收货人手机")
    private String mobile;
    @ApiModelProperty(name = "收货地址")
    private String address;
    @ApiModelProperty(name = "订单备注")
    private String remark;
    @ApiModelProperty(name = "支付方式：1=微信支付 2=支付宝支付 9=到货后面对面支付")
    private Integer payType;

    @ApiModelProperty(name = "订单明细列表")
    private List<OrderAddItemParam> items;
}
