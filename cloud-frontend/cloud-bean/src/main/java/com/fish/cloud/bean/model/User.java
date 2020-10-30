package com.fish.cloud.bean.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Data
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
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 用户邮箱
	 */
	private String mail;
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
	 * 头像
	 */
	private String img;
	/**
	 * M(男) or F(女)
	 */
	private String gender;
	/**
	 * 例如：2009-11-27
	 */
	@TableField("birth_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
	private String birthDate;
	/**
	 * 国
	 */
	private String country;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 市
	 */
	private String city;
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
	 * 微信openid
	 */
	@TableField("wechat_open_id")
	private String wechatOpenId;

	/**
	 * 微信用户union id
	 */
	@TableField("wechat_union_id")
	private String wechatUnionId;

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

	@Override
	protected Serializable pkVal() {
		return this.userId;
	}

}
