package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class ProdBrandAddParam {
    @ApiModelProperty(value = "Id")
    private Long brandId;
    @ApiModelProperty(value = "品牌名称")
    private String brandName;
    @ApiModelProperty(value = "品牌logo")
    private String logo;
    @ApiModelProperty(value = "大图")
    private String img;
    @ApiModelProperty(value = "简要描述")
    private String brief;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "排序")
    private Integer seq;
}
