package com.fish.cloud.bean.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商品分组标签
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_prod_tag")
public class ProdTag extends Model<ProdTag> {

    private static final long serialVersionUID = 1L;

    /**
     * 标签Id
     */
    @TableId("tag_code")
	private String tagCode;
    /**
     * 标题
     */
	@TableField("tag_name")
	private String tagName;
    /**
     * 店铺Id
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 默认类型(0:商家自定义,1:系统默认)
     */
	private Integer type;
    /**
     * 商品数量
     */
	@TableField("prod_num")
	private Long prodNum;
    /**
     * 列表样式(0:一列一个,1:一列两个,2:一列三个)
     */
	private Integer style;
    /**
     * 排序
     */
	private Integer seq;
    /**
     * 状态(1为正常,0为删除)
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


	public String getTagCode() {
		return tagCode;
	}

	public ProdTag setTagCode(String tagCode) {
		this.tagCode = tagCode;
		return this;
	}

	public String getTagName() {
		return tagName;
	}

	public ProdTag setTagName(String tagName) {
		this.tagName = tagName;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public ProdTag setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Integer getType() {
		return type;
	}

	public ProdTag setType(Integer type) {
		this.type = type;
		return this;
	}

	public Long getProdNum() {
		return prodNum;
	}

	public ProdTag setProdNum(Long prodNum) {
		this.prodNum = prodNum;
		return this;
	}

	public Integer getStyle() {
		return style;
	}

	public ProdTag setStyle(Integer style) {
		this.style = style;
		return this;
	}

	public Integer getSeq() {
		return seq;
	}

	public ProdTag setSeq(Integer seq) {
		this.seq = seq;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public ProdTag setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public ProdTag setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public ProdTag setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.tagCode;
	}

}
