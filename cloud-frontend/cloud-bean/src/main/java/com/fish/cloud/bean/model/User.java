package com.fish.cloud.bean.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@TableName("cloud_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户Id
     */
    @TableId("user_id")
	private String userId;
    /**
     * 用户名
     */
	@TableField("user_name")
	private String userName;
    /**
     * 登录密码
     */
	private String password;
    /**
     * 用户昵称
     */
	@TableField("nick_name")
	private String nickName;
    /**
     * 真实姓名
     */
	@TableField("real_name")
	private String realName;
    /**
     * 手机号码
     */
	private String mobile;
    /**
     * 用户邮箱
     */
	private String mail;
    /**
     * M(男) or F(女)
     */
	private String gender;
    /**
     * 例如：2009-11-27
     */
	@TableField("birth_date")
	private String birthDate;
    /**
     * 注册时间
     */
	@TableField("reg_time")
	private Date regTime;
    /**
     * 注册IP
     */
	@TableField("reg_ip")
	private String regIp;
    /**
     * 最后登录时间
     */
	@TableField("last_login_time")
	private Date lastLoginTime;
    /**
     * 最后登录IP
     */
	@TableField("last_login_ip")
	private String lastLoginIp;
    /**
     * 头像图片
     */
	private String img;
    /**
     * 会员等级
     */
	@TableField("grade_id")
	private Long gradeId;
    /**
     * 当前积分
     */
	@TableField("current_integral")
	private Integer currentIntegral;
    /**
     * 备注
     */
	private String remark;
    /**
     * 状态 1 正常 0 无效
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


	public String getUserId() {
		return userId;
	}

	public User setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public User setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getNickName() {
		return nickName;
	}

	public User setNickName(String nickName) {
		this.nickName = nickName;
		return this;
	}

	public String getRealName() {
		return realName;
	}

	public User setRealName(String realName) {
		this.realName = realName;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public User setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public String getMail() {
		return mail;
	}

	public User setMail(String mail) {
		this.mail = mail;
		return this;
	}

	public String getGender() {
		return gender;
	}

	public User setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public User setBirthDate(String birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public Date getRegTime() {
		return regTime;
	}

	public User setRegTime(Date regTime) {
		this.regTime = regTime;
		return this;
	}

	public String getRegIp() {
		return regIp;
	}

	public User setRegIp(String regIp) {
		this.regIp = regIp;
		return this;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public User setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
		return this;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public User setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
		return this;
	}

	public String getImg() {
		return img;
	}

	public User setImg(String img) {
		this.img = img;
		return this;
	}

	public Long getGradeId() {
		return gradeId;
	}

	public User setGradeId(Long gradeId) {
		this.gradeId = gradeId;
		return this;
	}

	public Integer getCurrentIntegral() {
		return currentIntegral;
	}

	public User setCurrentIntegral(Integer currentIntegral) {
		this.currentIntegral = currentIntegral;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public User setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public User setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public User setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public User setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.userId;
	}

}
