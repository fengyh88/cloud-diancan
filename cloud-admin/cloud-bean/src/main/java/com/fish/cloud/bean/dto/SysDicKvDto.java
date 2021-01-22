package com.fish.cloud.bean.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 系统字典kv
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
@Data
public class SysDicKvDto {

	private Long id;

    /**
     * 字典编码
     */
	private String dicCode;
    /**
     * key
     */
	private String key;
    /**
     * value
     */
	private String value;
    /**
     * 备注
     */
	private String remark;
    /**
     * 店铺Id 0表示全局配置
     */
	private Long shopId;
	/**
	 * 状态  0：禁用   1：启用
	 */
	private Integer status;

}
