package com.fish.cloud.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
@Data
public class RoleDto {

	private Long roleId;
    /**
     * 角色名称
     */
	private String roleName;
    /**
     * 店铺Id
     */
	private Long shopId;
    /**
     * 备注
     */
	private String remark;
	/**
	 * 状态  0：禁用   1：启用
	 */
	private Integer status;
    /**
     * 创建者Id
     */
	private Long createdBy;
    /**
     * 创建时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createdTime;

}
