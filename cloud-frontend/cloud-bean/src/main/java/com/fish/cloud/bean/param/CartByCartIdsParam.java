package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
public class CartByCartIdsParam {
    @ApiModelProperty(name = "cartIds")
    private List<Long> cartIds;
}
