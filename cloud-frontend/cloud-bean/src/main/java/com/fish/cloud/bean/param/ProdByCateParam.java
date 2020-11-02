package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class ProdByCateParam {
    @ApiModelProperty(value = "商品类目")
    private String cateId;
    @ApiModelProperty(value = "关键字")
    private String keyword;
}
