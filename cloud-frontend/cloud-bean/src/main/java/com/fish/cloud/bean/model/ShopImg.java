package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 店铺图
 * </p>
 *
 * @author fengyh
 * @since 2020-10-31
 */
@TableName("cloud_shop_img")
public class ShopImg extends Model<ShopImg> {

    private static final long serialVersionUID = 1L;

	@TableId(value="img_id", type= IdType.AUTO)
	private Long imgId;
    /**
     * 图片地址
     */
	@TableField("img_url")
	private String imgUrl;
    /**
     * 图片类型
     */
	@TableField("img_type")
	private String imgType;
    /**
     * 图片大小
     */
	@TableField("img_size")
	private Integer imgSize;
    /**
     * 上传时间
     */
	@TableField("upload_time")
	private Date uploadTime;
    /**
     * 图片关联表类型：1 店铺表
     */
	@TableField("link_type")
	private Integer linkType;
    /**
     * 图片关联的表主键Id
     */
	@TableField("link_id")
	private Long linkId;
    /**
     * 1 店铺表(1 主图 2 轮播图 3 详情图 )
     */
	@TableField("link_cate")
	private Integer linkCate;


	public Long getImgId() {
		return imgId;
	}

	public ShopImg setImgId(Long imgId) {
		this.imgId = imgId;
		return this;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public ShopImg setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
		return this;
	}

	public String getImgType() {
		return imgType;
	}

	public ShopImg setImgType(String imgType) {
		this.imgType = imgType;
		return this;
	}

	public Integer getImgSize() {
		return imgSize;
	}

	public ShopImg setImgSize(Integer imgSize) {
		this.imgSize = imgSize;
		return this;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public ShopImg setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
		return this;
	}

	public Integer getLinkType() {
		return linkType;
	}

	public ShopImg setLinkType(Integer linkType) {
		this.linkType = linkType;
		return this;
	}

	public Long getLinkId() {
		return linkId;
	}

	public ShopImg setLinkId(Long linkId) {
		this.linkId = linkId;
		return this;
	}

	public Integer getLinkCate() {
		return linkCate;
	}

	public ShopImg setLinkCate(Integer linkCate) {
		this.linkCate = linkCate;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.imgId;
	}

}
