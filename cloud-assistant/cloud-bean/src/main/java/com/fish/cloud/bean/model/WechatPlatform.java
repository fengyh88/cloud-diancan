package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 微信开发平台
 * </p>
 *
 * @author fengyh
 * @since 2020-11-02
 */
@Data
@TableName("cloud_wechat_platform")
public class WechatPlatform extends Model<WechatPlatform> {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;

	/**
	 * 店铺Id
	 */
	private Long shopId;
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
     * 状态 -1:删除 0: 禁用 1:启用
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
		return this.id;
	}

}
