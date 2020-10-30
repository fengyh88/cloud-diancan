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
 * 岗位
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_duty")
public class Duty extends Model<Duty> {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
	@TableId(value="duty_id", type= IdType.AUTO)
	private Long dutyId;
    /**
     * 名称
     */
	@TableField("duty_name")
	private String dutyName;
    /**
     * 商家Id
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 建立时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;


	public Long getDutyId() {
		return dutyId;
	}

	public Duty setDutyId(Long dutyId) {
		this.dutyId = dutyId;
		return this;
	}

	public String getDutyName() {
		return dutyName;
	}

	public Duty setDutyName(String dutyName) {
		this.dutyName = dutyName;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public Duty setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Duty setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Duty setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.dutyId;
	}

}
