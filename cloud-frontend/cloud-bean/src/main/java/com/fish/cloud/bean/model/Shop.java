package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 店铺
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@TableName("cloud_shop")
public class Shop extends Model<Shop> {

    private static final long serialVersionUID = 1L;

    /**
     * 店铺Id
     */
	@TableId(value="shop_id", type= IdType.AUTO)
	private Long shopId;
    /**
     * 店铺名称(数字、中文，英文(可混合，不可有特殊字符)，可修改)、不唯一
     */
	@TableField("shop_name")
	private String shopName;
    /**
     * 店铺类型
     */
	@TableField("shop_type")
	private Integer shopType;
    /**
     * 店铺行业(餐饮、生鲜果蔬、鲜花等)
     */
	private Integer industry;
    /**
     * 店铺简介(可修改)
     */
	private String brief;
    /**
     * 店铺公告(可修改)
     */
	private String notice;
    /**
     * 店长
     */
	private String owner;
    /**
     * 店铺绑定的手机(登录账号：唯一)
     */
	private String mobile;
    /**
     * 店铺联系电话
     */
	private String tel;
    /**
     * 店铺所在纬度(可修改)
     */
	private String lat;
    /**
     * 店铺所在经度(可修改)
     */
	private String lng;
    /**
     * 店铺省市区代码，用于回显
     */
	@TableField("pca_code")
	private String pcaCode;
    /**
     * 店铺所在省市区（描述）
     */
	@TableField("pca_name")
	private String pcaName;
    /**
     * 详细地址
     */
	private String address;
    /**
     * 每天营业时间段(可修改)
     */
	@TableField("open_time")
	private String openTime;
    /**
     * 每天关闭时间段(可修改)
     */
	@TableField("close_time")
	private String closeTime;
    /**
     * 店铺状态(-1:未开通 0: 停业中 1:营业中)，可修改
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


	public Long getShopId() {
		return shopId;
	}

	public Shop setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public String getShopName() {
		return shopName;
	}

	public Shop setShopName(String shopName) {
		this.shopName = shopName;
		return this;
	}

	public Integer getShopType() {
		return shopType;
	}

	public Shop setShopType(Integer shopType) {
		this.shopType = shopType;
		return this;
	}

	public Integer getIndustry() {
		return industry;
	}

	public Shop setIndustry(Integer industry) {
		this.industry = industry;
		return this;
	}

	public String getBrief() {
		return brief;
	}

	public Shop setBrief(String brief) {
		this.brief = brief;
		return this;
	}

	public String getNotice() {
		return notice;
	}

	public Shop setNotice(String notice) {
		this.notice = notice;
		return this;
	}

	public String getOwner() {
		return owner;
	}

	public Shop setOwner(String owner) {
		this.owner = owner;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public Shop setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public String getTel() {
		return tel;
	}

	public Shop setTel(String tel) {
		this.tel = tel;
		return this;
	}

	public String getLat() {
		return lat;
	}

	public Shop setLat(String lat) {
		this.lat = lat;
		return this;
	}

	public String getLng() {
		return lng;
	}

	public Shop setLng(String lng) {
		this.lng = lng;
		return this;
	}

	public String getPcaCode() {
		return pcaCode;
	}

	public Shop setPcaCode(String pcaCode) {
		this.pcaCode = pcaCode;
		return this;
	}

	public String getPcaName() {
		return pcaName;
	}

	public Shop setPcaName(String pcaName) {
		this.pcaName = pcaName;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Shop setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getOpenTime() {
		return openTime;
	}

	public Shop setOpenTime(String openTime) {
		this.openTime = openTime;
		return this;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public Shop setCloseTime(String closeTime) {
		this.closeTime = closeTime;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public Shop setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Shop setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Shop setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.shopId;
	}

}
