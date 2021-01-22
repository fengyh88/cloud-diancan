package com.fish.cloud.bean.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 系统字典
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
@Data
public class SysDicDto {

	private Long id;

    /**
     * 编码
     */
	private String dicCode;
    /**
     * 名称
     */
	private String dicName;
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
