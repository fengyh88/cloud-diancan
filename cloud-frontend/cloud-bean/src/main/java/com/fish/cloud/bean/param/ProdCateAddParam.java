package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class ProdCateAddParam {
    @ApiModelProperty(value = "类目Id")
    private Long cateId;
    @ApiModelProperty(value = "类目名称")
    private String cateName;
    @ApiModelProperty(value = "类目图标")
    private String icon;
    @ApiModelProperty(value = "类目的显示图片")
    private String img;
    @ApiModelProperty(value = "父节点")
    private Long pId;
    @ApiModelProperty(value = "分类层级")
    private Integer grade;
    @ApiModelProperty(value = "排序")
    private Integer seq;
}
