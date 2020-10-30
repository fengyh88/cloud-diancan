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
 * 用户优惠券
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@TableName("cloud_user_coupon")
public class UserCoupon extends Model<UserCoupon> {

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
     * 优惠券Id
     */
	@TableField("coupon_id")
	private Long couponId;
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
     * 领取时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 使用时间
     */
	@TableField("use_time")
	private Date useTime;
    /**
     * 1 已使用 0 未使用 -1已过期
     */
	private Integer status;


	public Long getId() {
		return id;
	}

	public UserCoupon setId(Long id) {
		this.id = id;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public UserCoupon setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public Long getCouponId() {
		return couponId;
	}

	public UserCoupon setCouponId(Long couponId) {
		this.couponId = couponId;
		return this;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public UserCoupon setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
		return this;
	}

	public Date getEndTime() {
		return endTime;
	}

	public UserCoupon setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public UserCoupon setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUseTime() {
		return useTime;
	}

	public UserCoupon setUseTime(Date useTime) {
		this.useTime = useTime;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public UserCoupon setStatus(Integer status) {
		this.status = status;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
