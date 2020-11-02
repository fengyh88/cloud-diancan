package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

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
@TableName("cloud_sys_config")
public class SysConfig extends Model<SysConfig> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * key
     */
	@TableField("param_key")
	private String paramKey;
    /**
     * value
     */
	@TableField("param_value")
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
	@TableField("shop_id")
	private Long shopId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;


	public Long getId() {
		return id;
	}

	public SysConfig setId(Long id) {
		this.id = id;
		return this;
	}

	public String getParamKey() {
		return paramKey;
	}

	public SysConfig setParamKey(String paramKey) {
		this.paramKey = paramKey;
		return this;
	}

	public String getParamValue() {
		return paramValue;
	}

	public SysConfig setParamValue(String paramValue) {
		this.paramValue = paramValue;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public SysConfig setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public SysConfig setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public SysConfig setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public SysConfig setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public SysConfig setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
