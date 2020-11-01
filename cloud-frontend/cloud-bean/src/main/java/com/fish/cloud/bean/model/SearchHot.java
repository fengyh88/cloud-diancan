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
 * 热搜
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@TableName("cloud_search_hot")
public class SearchHot extends Model<SearchHot> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
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
     * 点击次数
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

	public SearchHot setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public SearchHot setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public String getContent() {
		return content;
	}

	public SearchHot setContent(String content) {
		this.content = content;
		return this;
	}

	public Integer getTimes() {
		return times;
	}

	public SearchHot setTimes(Integer times) {
		this.times = times;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public SearchHot setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public SearchHot setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
