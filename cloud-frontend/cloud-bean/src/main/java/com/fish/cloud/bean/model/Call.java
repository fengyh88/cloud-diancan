package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 呼叫表
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@TableName("cloud_call")
public class Call extends Model<Call> {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 店铺Id 0表示全局公告
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 用户Id
     */
	@TableField("user_id")
	private Long userId;
    /**
     * 桌号Id
     */
	@TableField("res_id")
	private Long resId;
    /**
     * 公告标题
     */
	private String title;
    /**
     * 公告内容
     */
	private String content;
    /**
     * 状态(1:呼叫 2:已读)
     */
	private Integer status;
    /**
     * 已读员工Id
     */
	@TableField("emp_id")
	private Long empId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;


	public Long getId() {
		return id;
	}

	public Call setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public Call setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public Call setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public Long getResId() {
		return resId;
	}

	public Call setResId(Long resId) {
		this.resId = resId;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Call setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getContent() {
		return content;
	}

	public Call setContent(String content) {
		this.content = content;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public Call setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Long getEmpId() {
		return empId;
	}

	public Call setEmpId(Long empId) {
		this.empId = empId;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Call setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
