package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
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
	private String email;
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
	 * 微信OpenId
	 */
	@TableField("wechat_open_id")
	private String wechatOpenId;
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
