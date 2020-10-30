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
public class ProdDto {

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

    @ApiModelProperty(value = "销售属性组合字符串 格式是p1:v1:s1;p2:v2,s1")
    private String attr;

    @ApiModelProperty(value = "简要描述,卖点等")
    private String brief;

    @ApiModelProperty(value = "详细描述")
    private String content;

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

    @ApiModelProperty(value = "上架时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date putonTime;

    @ApiModelProperty(value = "商品类目名称")
    private String cateName;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "单位")
    private String unitName;
}
