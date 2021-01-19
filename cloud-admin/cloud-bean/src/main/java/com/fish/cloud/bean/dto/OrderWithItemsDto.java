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
public class OrderWithItemsDto {
    @ApiModelProperty(value = "订单Id")
    private Long orderId;

    @ApiModelProperty(value = "台桌Id")
    private Long tableId;

    @ApiModelProperty(value = "台桌名称")
    private String tableName;

    @ApiModelProperty(value = "订购用户Id")
    private String userId;

    @ApiModelProperty(value = "订单流水号")
    private String orderNumber;

    @ApiModelProperty(value = "订单备注")
    private String remark;

    @ApiModelProperty(value = "总值")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "用户优惠券Id")
    private Long userCouponId;

    @ApiModelProperty(value = "优惠总额")
    private BigDecimal reduceAmount;

    @ApiModelProperty(value = "实际总值")
    private BigDecimal actualAmount;

    @ApiModelProperty(value = "支付方式 1 微信支付 2 支付宝 3 现金支付")
    private Integer payType;

    @ApiModelProperty(value = "订单状态 1已提交 9已结算 13关闭，失败")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "完成时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date completeTime;

    @ApiModelProperty(value = "订单明细")
    private List<OrderItemDto> orderItems;
}
