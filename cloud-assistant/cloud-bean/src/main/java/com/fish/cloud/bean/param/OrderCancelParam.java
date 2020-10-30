package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author fengyh
 * @Date 2020/3/8 23:28
 * @Version 1.0
 */
@Data
public class OrderCancelParam {
    private long id;
    @ApiModelProperty(name = "取消订单原因")
    private String content;
}
