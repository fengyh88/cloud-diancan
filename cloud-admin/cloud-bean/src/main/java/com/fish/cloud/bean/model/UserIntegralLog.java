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
 * 用户积分日志
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_user_integral_log")
public class UserIntegralLog extends Model<UserIntegralLog> {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * userId
     */
	@TableField("user_id")
	private String userId;
    /**
     * 增/减积分
     */
	private Integer integral;
    /**
     * 描述
     */
	private String des;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;


	public Long getId() {
		return id;
	}

	public UserIntegralLog setId(Long id) {
		this.id = id;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public UserIntegralLog setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public Integer getIntegral() {
		return integral;
	}

	public UserIntegralLog setIntegral(Integer integral) {
		this.integral = integral;
		return this;
	}

	public String getDes() {
		return des;
	}

	public UserIntegralLog setDes(String des) {
		this.des = des;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public UserIntegralLog setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
