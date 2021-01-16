package com.fish.cloud.bean.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

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
