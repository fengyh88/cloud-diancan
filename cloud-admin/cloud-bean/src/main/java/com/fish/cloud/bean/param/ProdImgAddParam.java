package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel
@Data
public class ProdImgAddParam {

    @ApiModelProperty(value = "Id")
    private Long imgId;

    @ApiModelProperty(value = "图片地址")
    private String imgUrl;

    @ApiModelProperty(value = "图片类型")
    private String imgType;

    @ApiModelProperty(value = "图片大小")
    private Integer imgSize;

    @ApiModelProperty(value = "1 商品表 2 商品规格表")
    private Integer linkType;

    @ApiModelProperty(value = "图片关联的表主键Id")
    private Long linkId;

    @ApiModelProperty(value = "1 商品表(1 主图 2 轮播图 3 详情图) 2 规格表(1 主图 2 轮播图 3 详情图)")
    private Integer linkCate;
}
