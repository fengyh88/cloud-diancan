package com.fish.cloud.bean.dto;

import lombok.Data;

import java.util.List;

/**
 * <p>
 * 商品属性
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
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
	 * 默认是1 正常状态,0 禁用状态 -1 删除状态
	 */
	private Integer status;
	/**
	 * 属性值列表
	 */
	private List<String> propValueList;
}
