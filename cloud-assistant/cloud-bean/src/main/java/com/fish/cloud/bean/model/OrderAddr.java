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
 * 订单收货地址
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_order_addr")
public class OrderAddr extends Model<OrderAddr> {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 订单Id
     */
	@TableField("order_id")
	private Long orderId;
    /**
     * 地址Id
     */
	@TableField("addr_id")
	private Long addrId;
    /**
     * 收货人
     */
	private String receiver;
    /**
     * 手机
     */
	private String mobile;
    /**
     * 省Id
     */
	@TableField("province_id")
	private Long provinceId;
    /**
     * 省
     */
	private String province;
    /**
     * 城市Id
     */
	@TableField("city_id")
	private Long cityId;
    /**
     * 城市
     */
	private String city;
    /**
     * 区域Id
     */
	@TableField("area_id")
	private Long areaId;
    /**
     * 区
     */
	private String area;
    /**
     * 地址
     */
	private String addr;
    /**
     * 邮编
     */
	@TableField("post_code")
	private String postCode;
    /**
     * 建立时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 版本号
     */
	private Integer version;


	public Long getId() {
		return id;
	}

	public OrderAddr setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getOrderId() {
		return orderId;
	}

	public OrderAddr setOrderId(Long orderId) {
		this.orderId = orderId;
		return this;
	}

	public Long getAddrId() {
		return addrId;
	}

	public OrderAddr setAddrId(Long addrId) {
		this.addrId = addrId;
		return this;
	}

	public String getReceiver() {
		return receiver;
	}

	public OrderAddr setReceiver(String receiver) {
		this.receiver = receiver;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public OrderAddr setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public OrderAddr setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
		return this;
	}

	public String getProvince() {
		return province;
	}

	public OrderAddr setProvince(String province) {
		this.province = province;
		return this;
	}

	public Long getCityId() {
		return cityId;
	}

	public OrderAddr setCityId(Long cityId) {
		this.cityId = cityId;
		return this;
	}

	public String getCity() {
		return city;
	}

	public OrderAddr setCity(String city) {
		this.city = city;
		return this;
	}

	public Long getAreaId() {
		return areaId;
	}

	public OrderAddr setAreaId(Long areaId) {
		this.areaId = areaId;
		return this;
	}

	public String getArea() {
		return area;
	}

	public OrderAddr setArea(String area) {
		this.area = area;
		return this;
	}

	public String getAddr() {
		return addr;
	}

	public OrderAddr setAddr(String addr) {
		this.addr = addr;
		return this;
	}

	public String getPostCode() {
		return postCode;
	}

	public OrderAddr setPostCode(String postCode) {
		this.postCode = postCode;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public OrderAddr setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Integer getVersion() {
		return version;
	}

	public OrderAddr setVersion(Integer version) {
		this.version = version;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
