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
 * 商品图
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_prod_img")
public class ProdImg extends Model<ProdImg> {

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
     * 图片关联的表主键Id
     */
	@TableField("link_id")
	private Long linkId;
    /**
     * 图片关联表类型：1 商品表
     */
	@TableField("link_type")
	private Integer linkType;
    /**
     * 1 商品表(1 轮播图，2 详情图)
     */
	@TableField("link_cate")
	private Integer linkCate;


	public Long getImgId() {
		return imgId;
	}

	public ProdImg setImgId(Long imgId) {
		this.imgId = imgId;
		return this;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public ProdImg setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
		return this;
	}

	public String getImgType() {
		return imgType;
	}

	public ProdImg setImgType(String imgType) {
		this.imgType = imgType;
		return this;
	}

	public Integer getImgSize() {
		return imgSize;
	}

	public ProdImg setImgSize(Integer imgSize) {
		this.imgSize = imgSize;
		return this;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public ProdImg setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
		return this;
	}

	public Long getLinkId() {
		return linkId;
	}

	public ProdImg setLinkId(Long linkId) {
		this.linkId = linkId;
		return this;
	}

	public Integer getLinkType() {
		return linkType;
	}

	public ProdImg setLinkType(Integer linkType) {
		this.linkType = linkType;
		return this;
	}

	public Integer getLinkCate() {
		return linkCate;
	}

	public ProdImg setLinkCate(Integer linkCate) {
		this.linkCate = linkCate;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.imgId;
	}

}
