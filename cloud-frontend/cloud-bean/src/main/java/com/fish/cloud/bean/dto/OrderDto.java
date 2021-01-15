package com.fish.cloud.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ApiModel
public class OrderDto {
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

    @ApiModelProperty(value = "总值")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "实际总值")
    private BigDecimal actualAmount;

    @ApiModelProperty(value = "用户优惠券Id")
    private Long userCouponId;

    @ApiModelProperty(value = "优惠总额")
    private BigDecimal reduceAmount;

    @ApiModelProperty(value = "订单备注")
    private String remark;

    @ApiModelProperty(value = "订单状态")
    private Integer status;

    @ApiModelProperty(value = "订单商品总数")
    private Integer prodNum;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "完成时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date completeTime;

    @ApiModelProperty(value = "取消时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cancelTime;

    @ApiModelProperty(value = "订单明细")
    private List<OrderItemDto> orderItems;

}
