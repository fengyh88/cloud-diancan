package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel
@Data
public class ShopImgAddParam {

    @ApiModelProperty(value = "Id")
    private Long imgId;

    @ApiModelProperty(value = "图片地址")
    private String imgUrl;

    @ApiModelProperty(value = "图片类型")
    private String imgType;

    @ApiModelProperty(value = "图片大小")
    private Integer imgSize;

    @ApiModelProperty(value = "上传时间")
    private Date uploadTime;

    @ApiModelProperty(value = "图片关联的表主键Id")
    private Long linkId;

    @ApiModelProperty(value = "1 轮播图，2 详情图")
    private Integer linkCate;
}
