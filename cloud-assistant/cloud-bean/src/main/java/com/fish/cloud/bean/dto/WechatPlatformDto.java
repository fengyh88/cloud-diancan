package com.fish.cloud.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
@NoArgsConstructor
public class WechatPlatformDto {

	private Long id;

    /**
     * 描述
     */
	private String des;
    /**
     * 微信公众号Id
     */
	private String wechatPlatformId;
    /**
     * 微信小程序Id
     */
	private String wechatAppId;
    /**
     * 微信小程序secretkey
     */
	private String wechatSecretKey;
    /**
     * 状态 -1:删除 0: 禁用 1:启用
     */
	private Integer status;
    /**
     * 创建时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
    /**
     * 更新时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

}
