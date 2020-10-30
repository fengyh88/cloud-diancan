package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 运费包邮
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_dvy_free")
public class DvyFree extends Model<DvyFree> {

    private static final long serialVersionUID = 1L;

    /**
     * 指定条件包邮项Id
     */
	@TableId(value="free_id", type= IdType.AUTO)
	private Long freeId;
    /**
     * 包邮方式 （1全场包邮 2满金额包邮 3地区包邮）
     */
	@TableField("free_type")
	private Integer freeType;
    /**
     * 满金额
     */
	private BigDecimal amount;
    /**
     * json列表，城市Id
     */
	private Long cities;
    /**
     * 店铺Id
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 状态
     */
	private Integer status;
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


	public Long getFreeId() {
		return freeId;
	}

	public DvyFree setFreeId(Long freeId) {
		this.freeId = freeId;
		return this;
	}

	public Integer getFreeType() {
		return freeType;
	}

	public DvyFree setFreeType(Integer freeType) {
		this.freeType = freeType;
		return this;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public DvyFree setAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	public Long getCities() {
		return cities;
	}

	public DvyFree setCities(Long cities) {
		this.cities = cities;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public DvyFree setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public DvyFree setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public DvyFree setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public DvyFree setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.freeId;
	}

}
