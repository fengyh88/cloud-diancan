package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class OrderCancelParam {
    @ApiModelProperty(name = "id")
    private Long id;
    @ApiModelProperty(name = "取消订单原因")
    private String content;
}
