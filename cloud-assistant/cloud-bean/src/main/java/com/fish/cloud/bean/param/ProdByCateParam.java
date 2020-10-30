package com.fish.cloud.bean.param;

import lombok.Data;

/**
 * @Description
 * @Author fengyh
 * @Date 2020/3/8 23:08
 * @Version 1.0
 */
@Data
public class ProdByCateParam extends ProdParam {
    private Long cateId;
    private String keyword;
}
