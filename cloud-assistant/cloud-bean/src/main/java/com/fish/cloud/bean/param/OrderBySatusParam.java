package com.fish.cloud.bean.param;

import lombok.Data;

/**
 * @Description
 * @Author fengyh
 * @Date 2020/3/8 23:24
 * @Version 1.0
 */
@Data
public class OrderBySatusParam {
    /**
     * 0全部 1待付款 2待发货 3待收货 4已完成
     */
    private Integer status;
}
