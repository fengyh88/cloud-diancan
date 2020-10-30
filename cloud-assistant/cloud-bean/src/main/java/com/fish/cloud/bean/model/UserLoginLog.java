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
 * 用户登录日志
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_user_login_log")
public class UserLoginLog extends Model<UserLoginLog> {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 用户Id
     */
	@TableField("user_id")
	private String userId;
    /**
     * 终端类型 1小程序 2PC Web
     */
	@TableField("app_type")
	private Integer appType;
    /**
     * IP
     */
	private String ip;
    /**
     * 时间
     */
	@TableField("login_time")
	private Date loginTime;


	public Long getId() {
		return id;
	}

	public UserLoginLog setId(Long id) {
		this.id = id;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public UserLoginLog setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public Integer getAppType() {
		return appType;
	}

	public UserLoginLog setAppType(Integer appType) {
		this.appType = appType;
		return this;
	}

	public String getIp() {
		return ip;
	}

	public UserLoginLog setIp(String ip) {
		this.ip = ip;
		return this;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public UserLoginLog setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
