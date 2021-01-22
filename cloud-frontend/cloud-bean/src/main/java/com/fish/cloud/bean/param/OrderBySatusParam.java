package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class OrderBySatusParam {

    @ApiModelProperty(value = "0全部  1已提交 9已结算 13关闭，失败")
    private Integer status;
}
