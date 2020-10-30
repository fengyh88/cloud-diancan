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
 * 短信记录
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_sms_log")
public class SmsLog extends Model<SmsLog> {

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
     * 短信类型  1:注册  2:验证
     */
	@TableField("sms_type")
	private Integer smsType;
    /**
     * 手机号码
     */
	private String mobile;
    /**
     * 短信内容
     */
	private String content;
    /**
     * 手机验证码
     */
	@TableField("verification_code")
	private String verificationCode;
    /**
     * 发送时间
     */
	@TableField("rec_time")
	private Date recTime;
    /**
     * 店铺id 0表示全局
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 状态  1:有效  0：失效
     */
	private Integer status;


	public Long getId() {
		return id;
	}

	public SmsLog setId(Long id) {
		this.id = id;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public SmsLog setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public Integer getSmsType() {
		return smsType;
	}

	public SmsLog setSmsType(Integer smsType) {
		this.smsType = smsType;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public SmsLog setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public String getContent() {
		return content;
	}

	public SmsLog setContent(String content) {
		this.content = content;
		return this;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public SmsLog setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
		return this;
	}

	public Date getRecTime() {
		return recTime;
	}

	public SmsLog setRecTime(Date recTime) {
		this.recTime = recTime;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public SmsLog setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public SmsLog setStatus(Integer status) {
		this.status = status;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
