package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 微信开发平台
 * </p>
 *
 * @author fengyh
 * @since 2020-03-13
 */
@TableName("cloud_wechat_platform")
public class WechatPlatform extends Model<WechatPlatform> {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 类型
     */
	private Integer type;
    /**
     * 描述
     */
	private String des;
    /**
     * 微信公众号Id
     */
	@TableField("wechat_platform_id")
	private String wechatPlatformId;
    /**
     * 微信小程序Id
     */
	@TableField("wechat_app_id")
	private String wechatAppId;
    /**
     * 微信小程序secretkey
     */
	@TableField("wechat_secret_key")
	private String wechatSecretKey;
    /**
     * 状态，可修改
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


	public Long getId() {
		return id;
	}

	public WechatPlatform setId(Long id) {
		this.id = id;
		return this;
	}

	public Integer getType() {
		return type;
	}

	public WechatPlatform setType(Integer type) {
		this.type = type;
		return this;
	}

	public String getDes() {
		return des;
	}

	public WechatPlatform setDes(String des) {
		this.des = des;
		return this;
	}

	public String getWechatPlatformId() {
		return wechatPlatformId;
	}

	public WechatPlatform setWechatPlatformId(String wechatPlatformId) {
		this.wechatPlatformId = wechatPlatformId;
		return this;
	}

	public String getWechatAppId() {
		return wechatAppId;
	}

	public WechatPlatform setWechatAppId(String wechatAppId) {
		this.wechatAppId = wechatAppId;
		return this;
	}

	public String getWechatSecretKey() {
		return wechatSecretKey;
	}

	public WechatPlatform setWechatSecretKey(String wechatSecretKey) {
		this.wechatSecretKey = wechatSecretKey;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public WechatPlatform setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public WechatPlatform setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public WechatPlatform setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
