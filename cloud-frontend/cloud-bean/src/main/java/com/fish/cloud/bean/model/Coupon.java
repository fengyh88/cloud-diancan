package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 优惠券
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_coupon")
public class Coupon extends Model<Coupon> {

    private static final long serialVersionUID = 1L;

    /**
     * 优惠券Id
     */
	@TableId(value="coupon_id", type= IdType.AUTO)
	private Long couponId;
    /**
     * 店铺id 0表示全局
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 优惠券名称
     */
	@TableField("coupon_name")
	private String couponName;
    /**
     * 简介
     */
	private String intro;
    /**
     * 图片
     */
	private String pic;
    /**
     * 优惠券类型：1=折扣，2=满减
     */
	@TableField("discount_type")
	private Integer discountType;
    /**
     * 最低消费金额
     */
	@TableField("min_amount")
	private BigDecimal minAmount;
    /**
     * 优惠金额
     */
	@TableField("sub_amount")
	private BigDecimal subAmount;
    /**
     * 折扣率
     */
	private BigDecimal discount;
    /**
     * 到期类型：1=领取后N天过期，2=指定有效期
     */
	@TableField("expire_type")
	private Integer expireType;
    /**
     * 有效天数，expire_type=1时
     */
	@TableField("expire_day")
	private Integer expireDay;
    /**
     * 有效期开始时间
     */
	@TableField("begin_time")
	private Date beginTime;
    /**
     * 有效期结束时间
     */
	@TableField("end_time")
	private Date endTime;
    /**
     * 发放总数量
     */
	@TableField("total_num")
	private Integer totalNum;
    /**
     * 适用商品分类列
     */
	@TableField("cate_id_list")
	private String cateIdList;
    /**
     * 适用商品列
     */
	@TableField("prod_id_list")
	private String prodIdList;
    /**
     * 售价
     */
	private BigDecimal price;
    /**
     * 是否加入领券中心 0--不加入领券中心 1--加入领券中心
     */
	@TableField("join_coupon")
	private Integer joinCoupon;
    /**
     * 是否加入积分商城 0--不加入 1--加入
     */
	@TableField("join_integral")
	private Integer joinIntegral;
    /**
     * 兑换需要积分数量
     */
	private Integer integral;
    /**
     * 积分商城发放总数
     */
	@TableField("integral_total_num")
	private Integer integralTotalNum;
    /**
     * 积分商城每人限制兑换数量
     */
	@TableField("integral_user_num")
	private Integer integralUserNum;
    /**
     * 排序
     */
	private Integer seq;
    /**
     * 0 禁用 1 启用 -1删除
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


	public Long getCouponId() {
		return couponId;
	}

	public Coupon setCouponId(Long couponId) {
		this.couponId = couponId;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public Coupon setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public String getCouponName() {
		return couponName;
	}

	public Coupon setCouponName(String couponName) {
		this.couponName = couponName;
		return this;
	}

	public String getIntro() {
		return intro;
	}

	public Coupon setIntro(String intro) {
		this.intro = intro;
		return this;
	}

	public String getPic() {
		return pic;
	}

	public Coupon setPic(String pic) {
		this.pic = pic;
		return this;
	}

	public Integer getDiscountType() {
		return discountType;
	}

	public Coupon setDiscountType(Integer discountType) {
		this.discountType = discountType;
		return this;
	}

	public BigDecimal getMinAmount() {
		return minAmount;
	}

	public Coupon setMinAmount(BigDecimal minAmount) {
		this.minAmount = minAmount;
		return this;
	}

	public BigDecimal getSubAmount() {
		return subAmount;
	}

	public Coupon setSubAmount(BigDecimal subAmount) {
		this.subAmount = subAmount;
		return this;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public Coupon setDiscount(BigDecimal discount) {
		this.discount = discount;
		return this;
	}

	public Integer getExpireType() {
		return expireType;
	}

	public Coupon setExpireType(Integer expireType) {
		this.expireType = expireType;
		return this;
	}

	public Integer getExpireDay() {
		return expireDay;
	}

	public Coupon setExpireDay(Integer expireDay) {
		this.expireDay = expireDay;
		return this;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public Coupon setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
		return this;
	}

	public Date getEndTime() {
		return endTime;
	}

	public Coupon setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public Coupon setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
		return this;
	}

	public String getCateIdList() {
		return cateIdList;
	}

	public Coupon setCateIdList(String cateIdList) {
		this.cateIdList = cateIdList;
		return this;
	}

	public String getProdIdList() {
		return prodIdList;
	}

	public Coupon setProdIdList(String prodIdList) {
		this.prodIdList = prodIdList;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Coupon setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public Integer getJoinCoupon() {
		return joinCoupon;
	}

	public Coupon setJoinCoupon(Integer joinCoupon) {
		this.joinCoupon = joinCoupon;
		return this;
	}

	public Integer getJoinIntegral() {
		return joinIntegral;
	}

	public Coupon setJoinIntegral(Integer joinIntegral) {
		this.joinIntegral = joinIntegral;
		return this;
	}

	public Integer getIntegral() {
		return integral;
	}

	public Coupon setIntegral(Integer integral) {
		this.integral = integral;
		return this;
	}

	public Integer getIntegralTotalNum() {
		return integralTotalNum;
	}

	public Coupon setIntegralTotalNum(Integer integralTotalNum) {
		this.integralTotalNum = integralTotalNum;
		return this;
	}

	public Integer getIntegralUserNum() {
		return integralUserNum;
	}

	public Coupon setIntegralUserNum(Integer integralUserNum) {
		this.integralUserNum = integralUserNum;
		return this;
	}

	public Integer getSeq() {
		return seq;
	}

	public Coupon setSeq(Integer seq) {
		this.seq = seq;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public Coupon setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Coupon setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Coupon setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.couponId;
	}

}
