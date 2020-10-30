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
 * 送货方式
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_dvy")
public class Dvy extends Model<Dvy> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	@TableId(value="dvy_id", type= IdType.AUTO)
	private Long dvyId;
    /**
     * 编码
     */
	@TableField("dvy_code")
	private String dvyCode;
    /**
     * 名称
     */
	@TableField("dvy_name")
	private String dvyName;
    /**
     * 运费
     */
	@TableField("dvy_fee")
	private BigDecimal dvyFee;
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


	public Long getDvyId() {
		return dvyId;
	}

	public Dvy setDvyId(Long dvyId) {
		this.dvyId = dvyId;
		return this;
	}

	public String getDvyCode() {
		return dvyCode;
	}

	public Dvy setDvyCode(String dvyCode) {
		this.dvyCode = dvyCode;
		return this;
	}

	public String getDvyName() {
		return dvyName;
	}

	public Dvy setDvyName(String dvyName) {
		this.dvyName = dvyName;
		return this;
	}

	public BigDecimal getDvyFee() {
		return dvyFee;
	}

	public Dvy setDvyFee(BigDecimal dvyFee) {
		this.dvyFee = dvyFee;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public Dvy setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public Dvy setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Dvy setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Dvy setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.dvyId;
	}

}
