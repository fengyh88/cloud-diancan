package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 系统配置信息
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@ApiModel
@Data
@TableName("cloud_sys_config")
public class SysConfig extends Model<SysConfig> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	/**
	 * key
	 */
	@ApiModelProperty(value = "key")
	@TableField("param_key")
	private String paramKey;
	/**
	 * value
	 */
	@ApiModelProperty(value = "value")
	@TableField("param_value")
	private String paramValue;
	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;
	/**
	 * 状态  1:启用  0：禁用 -1:删除
	 */
	@ApiModelProperty(value = "状态  1:启用  0：禁用 -1:删除")
	private Integer status;
	/**
	 * 店铺id 0表示全局配置
	 */
	@ApiModelProperty(value = "店铺id 0表示全局配置")
	@TableField("shop_id")
	private Long shopId;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@TableField("create_time")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@TableField("update_time")
	private Date updateTime;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}