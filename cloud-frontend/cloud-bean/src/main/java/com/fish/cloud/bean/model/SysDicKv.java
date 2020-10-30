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
 * 系统字典kv
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@ApiModel
@Data
@TableName("cloud_sys_dic_kv")
public class SysDicKv extends Model<SysDicKv> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	/**
	 * 字典编码
	 */
	@ApiModelProperty(value = "字典编码")
	@TableField("dic_code")
	private String dicCode;
	/**
	 * key
	 */
	@ApiModelProperty(value = "key")
	private String key;
	/**
	 * value
	 */
	@ApiModelProperty(value = "value")
	private String value;
	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;
	/**
	 * 店铺id 0表示全局配置
	 */
	@ApiModelProperty(value = "店铺id 0表示全局配置")
	@TableField("shop_id")
	private String shopId;
	/**
	 * 状态  0：禁用   1：启用
	 */
	@ApiModelProperty(value = "状态  0：禁用   1：启用")
	private Integer status;
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
