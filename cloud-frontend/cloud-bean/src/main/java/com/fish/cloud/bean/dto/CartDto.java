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
public class CartDto {

    @ApiModelProperty(value = "Id")
    private Long cartId;

    @ApiModelProperty(value = "店铺Id")
    private String shopId;

    @ApiModelProperty(value = "用户Id")
    private String userId;

    @ApiModelProperty(value = "商品Id")
    private Long prodId;

    @ApiModelProperty(value = "SkuId")
    private String skuId;

    @ApiModelProperty(value = "购物车商品个数")
    private Integer num;

    @ApiModelProperty(value = "购物时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cartTime;

    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    @ApiModelProperty(value = "商品编码")
    private String prodCode;

    @ApiModelProperty(value = "商品名称")
    private String prodName;

    @ApiModelProperty(value = "拼音简码")
    private String pinyin;

    @ApiModelProperty(value = "商品分类Id")
    private Long cateId;

    @ApiModelProperty(value = "品牌Id")
    private Long brandId;

    @ApiModelProperty(value = "原价")
    private BigDecimal oriPrice;

    @ApiModelProperty(value = "现价")
    private BigDecimal price;

    @ApiModelProperty(value = "会员价")
    private BigDecimal memPrice;

    @ApiModelProperty(value = "单位Id")
    private String unitId;

    @ApiModelProperty(value = "单位")
    private String unitName;

    @ApiModelProperty(value = "简要描述,卖点等")
    private String brief;

    @ApiModelProperty(value = "销量")
    private Integer sold;

    @ApiModelProperty(value = "库存")
    private Integer stock;

    @ApiModelProperty(value = "默认是1，表示正常状态, -1表示删除, 0下架")
    private Integer status;


    @ApiModelProperty(value = "主图")
    private String img;

    @ApiModelProperty(value = "是否启用sku")
    private Integer skuEnabled;


    @ApiModelProperty(value = "条形码")
    private String barcode;

    @ApiModelProperty(value = "sku名称")
    private String skuName;

    @ApiModelProperty(value = "sku原价")
    private BigDecimal skuOriPrice;

    @ApiModelProperty(value = "sku现价")
    private BigDecimal skuPrice;

    @ApiModelProperty(value = "sku库存")
    private Integer skuStock;

    @ApiModelProperty(value = "sku主图")
    private String skuImg;
}
