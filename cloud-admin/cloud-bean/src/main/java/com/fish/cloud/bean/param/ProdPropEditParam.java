package com.fish.cloud.bean.param;

import lombok.Data;

/**
 * <p>
 * 商品属性
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Data
public class ProdPropEditParam {

    /**
     * 属性Id
     */
	private Long propId;
    /**
     * 店铺Id
     */
	private Long shopId;
	/**
	 * 商品Id
	 */
	private Long prodId;
    /**
     * 属性名称
     */
	private String propName;
	/**
	 * 属性值
	 */
	private String propValue;

}
