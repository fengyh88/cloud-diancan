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
 * 用户收货地址
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_user_addr")
public class UserAddr extends Model<UserAddr> {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
	@TableId(value="addr_id", type= IdType.AUTO)
	private Long addrId;
    /**
     * 用户Id
     */
	@TableField("user_id")
	private String userId;
    /**
     * 收货人
     */
	private String receiver;
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
     * 城市
     */
	private String city;
    /**
     * 城市Id
     */
	@TableField("city_id")
	private Long cityId;
    /**
     * 区
     */
	private String area;
    /**
     * 区Id
     */
	@TableField("area_id")
	private Long areaId;
    /**
     * 邮编
     */
	@TableField("post_code")
	private String postCode;
    /**
     * 地址
     */
	private String addr;
    /**
     * 手机
     */
	private String mobile;
    /**
     * 是否默认地址 1是
     */
	@TableField("is_default")
	private Integer isDefault;
    /**
     * 状态,1正常，0无效
     */
	private Integer status;
    /**
     * 建立时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;
    /**
     * 版本号
     */
	private Integer version;


	public Long getAddrId() {
		return addrId;
	}

	public UserAddr setAddrId(Long addrId) {
		this.addrId = addrId;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public UserAddr setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getReceiver() {
		return receiver;
	}

	public UserAddr setReceiver(String receiver) {
		this.receiver = receiver;
		return this;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public UserAddr setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
		return this;
	}

	public String getProvince() {
		return province;
	}

	public UserAddr setProvince(String province) {
		this.province = province;
		return this;
	}

	public String getCity() {
		return city;
	}

	public UserAddr setCity(String city) {
		this.city = city;
		return this;
	}

	public Long getCityId() {
		return cityId;
	}

	public UserAddr setCityId(Long cityId) {
		this.cityId = cityId;
		return this;
	}

	public String getArea() {
		return area;
	}

	public UserAddr setArea(String area) {
		this.area = area;
		return this;
	}

	public Long getAreaId() {
		return areaId;
	}

	public UserAddr setAreaId(Long areaId) {
		this.areaId = areaId;
		return this;
	}

	public String getPostCode() {
		return postCode;
	}

	public UserAddr setPostCode(String postCode) {
		this.postCode = postCode;
		return this;
	}

	public String getAddr() {
		return addr;
	}

	public UserAddr setAddr(String addr) {
		this.addr = addr;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public UserAddr setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public UserAddr setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public UserAddr setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public UserAddr setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public UserAddr setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public Integer getVersion() {
		return version;
	}

	public UserAddr setVersion(Integer version) {
		this.version = version;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.addrId;
	}

}
