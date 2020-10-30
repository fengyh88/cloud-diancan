package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProdCateAddParam {
    @ApiModelProperty(name = "")
    private Long id;
    @ApiModelProperty(name = "")
    private String cateName;
    @ApiModelProperty(name = "")
    private String picUrl;
    @ApiModelProperty(name = "")
    private Integer seq;
    @ApiModelProperty(name = "")
    private long isShow;
}
