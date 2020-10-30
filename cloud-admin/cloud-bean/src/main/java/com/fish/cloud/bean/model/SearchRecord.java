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
 * 搜索记录
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@TableName("cloud_search_record")
public class SearchRecord extends Model<SearchRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 用户Id
     */
	@TableField("user_id")
	private String userId;
    /**
     * 店铺ID
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 内容
     */
	private String content;
    /**
     * 搜索次数
     */
	private Integer times;
    /**
     * 状态 0删除 1在用
     */
	private Integer status;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;


	public Long getId() {
		return id;
	}

	public SearchRecord setId(Long id) {
		this.id = id;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public SearchRecord setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public SearchRecord setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public String getContent() {
		return content;
	}

	public SearchRecord setContent(String content) {
		this.content = content;
		return this;
	}

	public Integer getTimes() {
		return times;
	}

	public SearchRecord setTimes(Integer times) {
		this.times = times;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public SearchRecord setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public SearchRecord setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
