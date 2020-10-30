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
 * 首页轮播图
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_homepage_gallary")
public class HomepageGallary extends Model<HomepageGallary> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="img_id", type= IdType.AUTO)
	private Long imgId;
    /**
     * 店铺Id
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 图片地址
     */
	@TableField("img_url")
	private String imgUrl;
    /**
     * 说明文字,描述
     */
	private String des;
    /**
     * 标题
     */
	private String title;
    /**
     * 终端类型 1小程序 2PC Web
     */
	@TableField("app_type")
	private Integer appType;
    /**
     * h5页面链接
     */
	@TableField("link_url")
	private String linkUrl;
    /**
     * 关联Id
     */
	@TableField("link_id")
	private Long linkId;
    /**
     * 关联表类型 1 商品规格表 2 h5
     */
	@TableField("link_type")
	private Integer linkType;
    /**
     * 顺序
     */
	private Integer seq;
    /**
     * 状态
     */
	private Integer status;
    /**
     * 上传时间
     */
	@TableField("upload_time")
	private Date uploadTime;


	public Long getImgId() {
		return imgId;
	}

	public HomepageGallary setImgId(Long imgId) {
		this.imgId = imgId;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public HomepageGallary setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public HomepageGallary setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
		return this;
	}

	public String getDes() {
		return des;
	}

	public HomepageGallary setDes(String des) {
		this.des = des;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public HomepageGallary setTitle(String title) {
		this.title = title;
		return this;
	}

	public Integer getAppType() {
		return appType;
	}

	public HomepageGallary setAppType(Integer appType) {
		this.appType = appType;
		return this;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public HomepageGallary setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
		return this;
	}

	public Long getLinkId() {
		return linkId;
	}

	public HomepageGallary setLinkId(Long linkId) {
		this.linkId = linkId;
		return this;
	}

	public Integer getLinkType() {
		return linkType;
	}

	public HomepageGallary setLinkType(Integer linkType) {
		this.linkType = linkType;
		return this;
	}

	public Integer getSeq() {
		return seq;
	}

	public HomepageGallary setSeq(Integer seq) {
		this.seq = seq;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public HomepageGallary setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public HomepageGallary setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.imgId;
	}

}
