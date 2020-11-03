package com.fish.cloud.bean.dto;

import com.fish.cloud.bean.annotation.Dic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel
@Data
public class OrderDetailDto implements IDtoDic {

    @ApiModelProperty(value = "订单Id")
    private Long orderId;

    @ApiModelProperty(value = "店铺Id")
    private Long shopId;

    @ApiModelProperty(value = "台桌Id")
    private Long tableId;

    @ApiModelProperty(value = "商品名称,多个商品将会以逗号隔开")
    private String prodName;

    @ApiModelProperty(value = "订购用户Id")
    private String userId;

    @ApiModelProperty(value = "订单流水号")
    private String orderNumber;

    @ApiModelProperty(value = "订单类型")
    @Dic(dicCode = "orderType")
    private Integer orderType;

    @ApiModelProperty(value = "总值")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "用户优惠券Id")
    private Long userCouponId;

    @ApiModelProperty(value = "优惠总额")
    private BigDecimal reduceAmount;

    @ApiModelProperty(value = "实际总值")
    private BigDecimal actualAmount;

    @ApiModelProperty(value = "支付方式 1 微信支付 2 支付宝 3 现金支付")
    @Dic(dicCode = "payType")
    private Integer payType;

    @ApiModelProperty(value = "是否支付，1：已经支付过，0：没有支付过")
    @Dic(dicCode = "isPayed")
    private Integer isPayed;

    @ApiModelProperty(value = "订单备注")
    private String remark;

    @ApiModelProperty(value = "订单状态 1：已提交 5：未支付 9:已支付 13:关闭，失败，17:完成，成功")
    @Dic(dicCode = "orderStatus")
    private Integer status;

    @ApiModelProperty(value = "订单商品总数")
    private Integer prodNum;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "付款时间")
    private Date payTime;

    @ApiModelProperty(value = "完成时间")
    private Date completeTime;

    @ApiModelProperty(value = "订单明细")
    private List<OrderItemDto> orderItems;
}
