package com.fish.cloud.bean.param;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * <p>
 * 单品SKU
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
@Data
public class ProdSkuEditParam {
    /**
     * 单品Id
     */
    private Long skuId;
    /**
     * 商品条码
     */
	private String barcode;
    /**
     * sku名称
     */
	private String skuName;
    /**
     * 原价
     */
	private BigDecimal oriPrice;
    /**
     * 价格
     */
	private BigDecimal price;
}
