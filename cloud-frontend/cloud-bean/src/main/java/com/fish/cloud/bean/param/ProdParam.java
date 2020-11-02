package com.fish.cloud.bean.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Description
 * @Author fengyh
 * @Date 2020/3/8 23:00
 * @Version 1.0
 */
@Data
public class ProdParam {
    /**
     * 关键字
     */
    @NotBlank(message = "商品名称不能为空")
    @Size(max = 200, message = "商品名称长度应该小于{max}")
    private String keyword;
    /**
     * 商品类目
     */
    private String cateId;
}
