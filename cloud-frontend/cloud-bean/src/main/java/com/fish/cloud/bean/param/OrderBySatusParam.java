package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class OrderBySatusParam {

    @ApiModelProperty(value = "0全部  1:待付款 2:已付款 3:已发货 4:已收货 5:已评价 6:已取消 （取消审核通过，不发货），7:已删除 回收站 8:已删除 永久删除 11:取消订单审核中")
    private Integer status;
}
