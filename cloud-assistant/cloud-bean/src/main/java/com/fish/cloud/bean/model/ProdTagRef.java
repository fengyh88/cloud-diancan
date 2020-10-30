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
 * 
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_prod_tag_ref")
public class ProdTagRef extends Model<ProdTagRef> {

    private static final long serialVersionUID = 1L;

    /**
     * 分组引用Id
     */
	@TableId(value="ref_id", type= IdType.AUTO)
	private Long refId;
    /**
     * 店铺Id
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 标签Id
     */
	@TableField("tag_code")
	private String tagCode;
    /**
     * 商品Id
     */
	@TableField("prod_id")
	private Long prodId;
    /**
     * 状态(1:正常,0:删除)
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


	public Long getRefId() {
		return refId;
	}

	public ProdTagRef setRefId(Long refId) {
		this.refId = refId;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public ProdTagRef setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public String getTagCode() {
		return tagCode;
	}

	public ProdTagRef setTagCode(String tagCode) {
		this.tagCode = tagCode;
		return this;
	}

	public Long getProdId() {
		return prodId;
	}

	public ProdTagRef setProdId(Long prodId) {
		this.prodId = prodId;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public ProdTagRef setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public ProdTagRef setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public ProdTagRef setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.refId;
	}

}
