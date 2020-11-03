package com.fish.cloud.bean.dto;

import com.fish.cloud.bean.annotation.Dic;
import com.fish.cloud.bean.model.ProdImg;
import com.fish.cloud.bean.model.ProdProp;
import com.fish.cloud.bean.model.ProdSku;
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
    @Dic(dicCode = "cate_id", dicTable = "cloud_prod_cate", dicText = "cate_name")
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
    @Dic(dicCode = "unit")
    private String unitId;

    @ApiModelProperty(value = "简要描述,卖点等")
    private String brief;

    @ApiModelProperty(value = "详细描述")
    private String content;

    @ApiModelProperty(value = "销量")
    private Integer sold;

    @ApiModelProperty(value = "库存")
    private Integer stock;

    @ApiModelProperty(value = "默认是1，表示正常状态, -1表示删除, 0下架")
    @Dic(dicCode = "statusPuton")
    private Integer status;

    @ApiModelProperty(value = "上架时间")
    private Date putonTime;

    @ApiModelProperty(value = "图片列表")
    private List<ProdImg> prodImgList;

    @ApiModelProperty(value = "商品规格列表")
    private List<ProdSku> prodSkuList;

    @ApiModelProperty(value = "商品规格文本")
    private String prodSkuText;

    @ApiModelProperty(value = "商品属性列表")
    private List<ProdProp> prodPropList;

    @ApiModelProperty(value = "商品属性文本")
    private String prodPropText;
}
