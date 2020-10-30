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
 * 订单收货地址
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@ApiModel
@Data
@TableName("cloud_order_addr")
public class OrderAddr extends Model<OrderAddr> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Id")
	@TableId(value="id", type= IdType.AUTO)
	private Long id;

	@ApiModelProperty(value = "订单Id")
	@TableField("order_id")
	private Long orderId;

	@ApiModelProperty(value = "地址Id")
	@TableField("addr_id")
	private Long addrId;

	@ApiModelProperty(value = "收货人")
	private String receiver;

	@ApiModelProperty(value = "手机")
	private String mobile;

	@ApiModelProperty(value = "省Id")
	@TableField("province_id")
	private Long provinceId;

	@ApiModelProperty(value = "省")
	private String province;

	@ApiModelProperty(value = "城市Id")
	@TableField("city_id")
	private Long cityId;

	@ApiModelProperty(value = "城市")
	private String city;

	@ApiModelProperty(value = "区域Id")
	@TableField("area_id")
	private Long areaId;

	@ApiModelProperty(value = "区")
	private String area;

	@ApiModelProperty(value = "地址")
	private String addr;

	@ApiModelProperty(value = "邮编")
	@TableField("post_code")
	private String postCode;

	@ApiModelProperty(value = "建立时间")
	@TableField("create_time")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	@ApiModelProperty(value = "版本号")
	private Integer version;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
