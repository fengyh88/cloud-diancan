package com.fish.cloud.bean.param;

import com.baomidou.mybatisplus.annotation.TableField;
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

    /**
     * 图片关联表类型：1 店铺表
     */
    @ApiModelProperty(value = "图片关联表类型：1 店铺表")
    private Integer linkType;

    @ApiModelProperty(value = "图片关联的表主键Id")
    private Long linkId;

    @ApiModelProperty(value = "1 轮播图，2 详情图")
    private Integer linkCate;
}
