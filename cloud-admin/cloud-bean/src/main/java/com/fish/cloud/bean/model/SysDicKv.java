package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统字典kv
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@TableName("cloud_sys_dic_kv")
public class SysDicKv extends Model<SysDicKv> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 字典编码
     */
	@TableField("dic_code")
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

	public SysDicKv setId(Long id) {
		this.id = id;
		return this;
	}

	public String getDicCode() {
		return dicCode;
	}

	public SysDicKv setDicCode(String dicCode) {
		this.dicCode = dicCode;
		return this;
	}

	public String getKey() {
		return key;
	}

	public SysDicKv setKey(String key) {
		this.key = key;
		return this;
	}

	public String getValue() {
		return value;
	}

	public SysDicKv setValue(String value) {
		this.value = value;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public SysDicKv setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public SysDicKv setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public SysDicKv setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public SysDicKv setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
