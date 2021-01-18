package com.fish.cloud.bean.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 系统配置信息
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
@Data
public class SysConfigDto{

	private String paramKey;

	private String paramValue;
    /**
     * 备注
     */
	private String remark;
    /**
     * 状态  1:启用  0：禁用 -1:删除
     */
	private Integer status;
	/**
	 * 店铺Id
	 */
	private Long shopId;

}
