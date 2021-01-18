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
     * 属性名称
     */
	private String propName;
	/**
	 * 属性值，多个值以英文逗号分隔
	 */
	private String propValue;

}
