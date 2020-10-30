package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author fengyh
 * @Date 2020/3/8 23:26
 * @Version 1.0
 */
@Data
public class OrderPayOnlineParam {
    private long id;
    @ApiModelProperty("微信支付")
    private Integer payType;
}
