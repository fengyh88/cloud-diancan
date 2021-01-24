package com.fish.cloud.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel
@Data
public class ProdDto implements IDtoDic {

    @ApiModelProperty(value = "商品Id")
    private Long prodId;

    @ApiModelProperty(value = "商品编码")
    private String prodCode;

    @ApiModelProperty(value = "商品名称")
    private String prodName;

    @ApiModelProperty(value = "拼音简码")
    private String pinyin;

    @ApiModelProperty(value = "店铺Id")
    private String shopId;

    @ApiModelProperty(value = "商品分类")
    private Long cateId;

    @ApiModelProperty(value = "商品分类")
    private String cateText;

    @ApiModelProperty(value = "原价")
    private BigDecimal oriPrice;

    @ApiModelProperty(value = "现价")
    private BigDecimal price;

    @ApiModelProperty(value = "会员价")
    private BigDecimal memPrice;

    @ApiModelProperty(value = "单位Id")
    private String unitId;

    @ApiModelProperty(value = "单位文本")
    private String unitText;

    @ApiModelProperty(value = "简要描述,卖点等")
    private String brief;

    @ApiModelProperty(value = "详细描述")
    private String content;

    @ApiModelProperty(value = "销量")
    private Integer sold;

    @ApiModelProperty(value = "默认是1 1正常 -1删除 0下架")
    private Integer status;

    @ApiModelProperty(value = "上架时间")
    private Date putonTime;

    @ApiModelProperty(value = "图片列表")
    private List<ProdImgDto> prodImgDtoList;

    @ApiModelProperty(value = "商品规格文本")
    private String prodSkuText;

    @ApiModelProperty(value = "商品属性文本")
    private String prodPropText;

    @ApiModelProperty(value = "商品主图片地址")
    private String prodImgUrl;
}
