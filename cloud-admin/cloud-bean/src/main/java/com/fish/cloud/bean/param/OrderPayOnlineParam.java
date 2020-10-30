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
    private Long id;
    @ApiModelProperty("1微信支付 2支付宝支付")
    private Integer payType;
}
