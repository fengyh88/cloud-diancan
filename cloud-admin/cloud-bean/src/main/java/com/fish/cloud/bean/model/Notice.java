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
 * 通知公告
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_notice")
public class Notice extends Model<Notice> {

    private static final long serialVersionUID = 1L;

    /**
     * 公告Id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 店铺Id 0表示全局公告
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 公告标题
     */
	private String title;
    /**
     * 公告内容
     */
	private String content;
    /**
     * h5地址
     */
	private String url;
    /**
     * 是否置顶
     */
	@TableField("is_top")
	private Integer isTop;
    /**
     * 发布时间
     */
	@TableField("publish_time")
	private Date publishTime;
    /**
     * 状态(1:公布 0:撤回)
     */
	private Integer status;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;


	public Long getId() {
		return id;
	}

	public Notice setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public Notice setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Notice setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getContent() {
		return content;
	}

	public Notice setContent(String content) {
		this.content = content;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public Notice setUrl(String url) {
		this.url = url;
		return this;
	}

	public Integer getIsTop() {
		return isTop;
	}

	public Notice setIsTop(Integer isTop) {
		this.isTop = isTop;
		return this;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public Notice setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public Notice setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Notice setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
