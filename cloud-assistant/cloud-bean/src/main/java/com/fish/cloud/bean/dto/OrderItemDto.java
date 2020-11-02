package com.fish.cloud.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel
@Data
public class OrderItemDto {

    @ApiModelProperty(value = "订单项Id")
    private Long orderItemId;

    @ApiModelProperty(value = "订单Id")
    private Long orderId;

    @ApiModelProperty(value = "用户Id")
    private String userId;

    @ApiModelProperty(value = "台桌Id")
    private Long tableId;

    @ApiModelProperty(value = "商品Id")
    private Long prodId;

    @ApiModelProperty(value = "商品名称")
    private String prodName;

    @ApiModelProperty(value = "商品主图片路径")
    private String prodImg;

    @ApiModelProperty(value = "商品属性JSON")
    private String prodProp;

    @ApiModelProperty(value = "商品SkuId")
    private Long skuId;

    @ApiModelProperty(value = "sku名称")
    private String skuName;

    @ApiModelProperty(value = "sku图片路径")
    private String skuImg;

    @ApiModelProperty(value = "sku属性JSON")
    private String skuProp;

    @ApiModelProperty(value = "商品个数")
    private Integer num;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal price;

    @ApiModelProperty(value = "商品总金额")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
