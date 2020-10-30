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
 * 系统字典
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_sys_dic")
public class SysDic extends Model<SysDic> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 编码
     */
	@TableField("dic_code")
	private String dicCode;
    /**
     * 名称
     */
	@TableField("dic_name")
	private String dicName;
    /**
     * 备注
     */
	private String remark;
    /**
     * 店铺id 0表示全局配置
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

	public SysDic setId(Long id) {
		this.id = id;
		return this;
	}

	public String getDicCode() {
		return dicCode;
	}

	public SysDic setDicCode(String dicCode) {
		this.dicCode = dicCode;
		return this;
	}

	public String getDicName() {
		return dicName;
	}

	public SysDic setDicName(String dicName) {
		this.dicName = dicName;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public SysDic setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public SysDic setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public SysDic setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public SysDic setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
