package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 文章
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_article")
public class Article extends Model<Article> {

    private static final long serialVersionUID = 1L;

    /**
     * 文章Id
     */
	@TableId(value="article_id", type= IdType.AUTO)
	private Long articleId;
    /**
     * 店铺ID 0表示全局
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 分类Id
     */
	@TableField("cate_id")
	private Long cateId;
    /**
     * 标题
     */
	private String title;
    /**
     * 内容
     */
	private String content;
    /**
     * H5页面地址
     */
	private String url;
    /**
     * 排序
     */
	private Integer seq;
    /**
     * 默认是1，表示发布,0为下线 -1未发布
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


	public Long getArticleId() {
		return articleId;
	}

	public Article setArticleId(Long articleId) {
		this.articleId = articleId;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public Article setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Long getCateId() {
		return cateId;
	}

	public Article setCateId(Long cateId) {
		this.cateId = cateId;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Article setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getContent() {
		return content;
	}

	public Article setContent(String content) {
		this.content = content;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public Article setUrl(String url) {
		this.url = url;
		return this;
	}

	public Integer getSeq() {
		return seq;
	}

	public Article setSeq(Integer seq) {
		this.seq = seq;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public Article setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Article setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Article setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.articleId;
	}

}
