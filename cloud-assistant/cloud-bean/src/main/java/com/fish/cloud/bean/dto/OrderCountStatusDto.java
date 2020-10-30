package com.fish.cloud.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author fengyh
 * @Date 2020/3/9 0:34
 * @Version 1.0
 */
@Data
public class OrderCountStatusDto {
    @ApiModelProperty(name = "待付款")
    private Integer notPay;
    @ApiModelProperty(name = "待发货")
    private Integer notSend;
    @ApiModelProperty(name = "待收货")
    private Integer send;
    @ApiModelProperty(name = "已完成")
    private Integer confirm;
}
