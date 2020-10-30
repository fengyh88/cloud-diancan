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
 * 品牌
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_prod_brand")
public class ProdBrand extends Model<ProdBrand> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="brand_id", type= IdType.AUTO)
	private Long brandId;
    /**
     * 品牌名称
     */
	@TableField("brand_name")
	private String brandName;
    /**
     * 品牌logo
     */
	private String logo;
    /**
     * 大图
     */
	private String img;
    /**
     * 品牌首字母
     */
	@TableField("first_char")
	private String firstChar;
    /**
     * 简要描述
     */
	private String brief;
    /**
     * 内容
     */
	private String content;
    /**
     * 备注
     */
	private String remark;
    /**
     * 顺序
     */
	private Integer seq;
    /**
     * 默认是1，表示正常状态,0为下线状态
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


	public Long getBrandId() {
		return brandId;
	}

	public ProdBrand setBrandId(Long brandId) {
		this.brandId = brandId;
		return this;
	}

	public String getBrandName() {
		return brandName;
	}

	public ProdBrand setBrandName(String brandName) {
		this.brandName = brandName;
		return this;
	}

	public String getLogo() {
		return logo;
	}

	public ProdBrand setLogo(String logo) {
		this.logo = logo;
		return this;
	}

	public String getImg() {
		return img;
	}

	public ProdBrand setImg(String img) {
		this.img = img;
		return this;
	}

	public String getFirstChar() {
		return firstChar;
	}

	public ProdBrand setFirstChar(String firstChar) {
		this.firstChar = firstChar;
		return this;
	}

	public String getBrief() {
		return brief;
	}

	public ProdBrand setBrief(String brief) {
		this.brief = brief;
		return this;
	}

	public String getContent() {
		return content;
	}

	public ProdBrand setContent(String content) {
		this.content = content;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public ProdBrand setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public Integer getSeq() {
		return seq;
	}

	public ProdBrand setSeq(Integer seq) {
		this.seq = seq;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public ProdBrand setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public ProdBrand setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public ProdBrand setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.brandId;
	}

}
