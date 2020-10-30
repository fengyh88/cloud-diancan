package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 用户收货地址
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@ApiModel
@Data
@TableName("cloud_user_addr")
public class UserAddr extends Model<UserAddr> {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
	@ApiModelProperty(name = "Id")
	@TableId(value="addr_id", type= IdType.AUTO)
	private Long addrId;
    /**
     * 用户Id
     */
	@ApiModelProperty(name = "用户Id")
	@TableField("user_id")
	private String userId;
    /**
     * 收货人
     */
	@ApiModelProperty(name = "收货人")
	private String receiver;
    /**
     * 省Id
     */
	@ApiModelProperty(name = "省Id")
	@TableField("province_id")
	private Long provinceId;
    /**
     * 省
     */
	@ApiModelProperty(name = "省")
	private String province;
    /**
     * 城市
     */
	@ApiModelProperty(name = "城市")
	private String city;
    /**
     * 城市Id
     */
	@ApiModelProperty(name = "城市Id")
	@TableField("city_id")
	private Long cityId;
    /**
     * 区
     */
	@ApiModelProperty(name = "区")
	private String area;
    /**
     * 区Id
     */
	@ApiModelProperty(name = "区Id")
	@TableField("area_id")
	private Long areaId;
    /**
     * 邮编
     */
	@ApiModelProperty(name = "邮编")
	@TableField("post_code")
	private String postCode;
    /**
     * 地址
     */
	@ApiModelProperty(name = "地址")
	private String addr;
    /**
     * 手机
     */
	@ApiModelProperty(name = "手机")
	private String mobile;
    /**
     * 是否默认地址 1是
     */
	@ApiModelProperty(name = "是否默认地址 1是")
	@TableField("is_default")
	private Integer isDefault;
    /**
     * 状态,1正常，0无效
     */
	@ApiModelProperty(name = "状态,1正常，0无效")
	private Integer status;
    /**
     * 建立时间
     */
	@ApiModelProperty(name = "建立时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新时间
     */
	@ApiModelProperty(name = "更新时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@TableField("update_time")
	private Date updateTime;
    /**
     * 版本号
     */
	@ApiModelProperty(name = "版本号")
	private Integer version;

	@Override
	protected Serializable pkVal() {
		return this.addrId;
	}

}
