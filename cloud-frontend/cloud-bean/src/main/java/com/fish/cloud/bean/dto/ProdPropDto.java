package com.fish.cloud.bean.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 * 商品属性
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
@Data
public class ProdPropDto {

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

	/**
	 * 属性值列表，以英文逗号分开
	 */
	private List<String> propValueList;

	/**
	 * 默认是1 正常状态,0 禁用状态 -1 删除状态
	 */
	private Integer status;

}
