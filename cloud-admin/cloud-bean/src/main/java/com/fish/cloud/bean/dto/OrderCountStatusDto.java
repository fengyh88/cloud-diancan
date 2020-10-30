package com.fish.cloud.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class OrderCountStatusDto {
    @ApiModelProperty(value = "所有订单数量")
    private Integer all;
    @ApiModelProperty(name = "待付款")
    private Integer notPay;
    @ApiModelProperty(name = "待发货")
    private Integer notSend;
    @ApiModelProperty(name = "已发货")
    private Integer send;
    @ApiModelProperty(name = "已收货")
    private Integer confirm;
    @ApiModelProperty(name = "已取消")
    private Integer cancel;
    @ApiModelProperty(value = "已删除")
    private Integer close;
    @ApiModelProperty(value = "取消待审核")
    private Integer cancelAudit;
}
