package com.fish.cloud.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class OrderCountStatusDto {
    @ApiModelProperty(value = "所有订单数量")
    private Integer all;
    @ApiModelProperty(name = "已提交")
    private Integer submitted;
    @ApiModelProperty(name = "已支付")
    private Integer payed;
    @ApiModelProperty(value = "关闭，失败")
    private Integer closed;
    @ApiModelProperty(value = "完成，成功")
    private Integer completed;
}
