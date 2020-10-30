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
 * 订单
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_order")
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单Id
     */
	@TableId(value="order_id", type= IdType.AUTO)
	private Long orderId;
    /**
     * 店铺Id
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 商品名称,多个商品将会以逗号隔开
     */
	@TableField("prod_name")
	private String prodName;
    /**
     * 订购用户Id
     */
	@TableField("user_id")
	private String userId;
    /**
     * 订单流水号
     */
	@TableField("order_number")
	private String orderNumber;
    /**
     * 订单类型
     */
	@TableField("order_type")
	private Integer orderType;
    /**
     * 总值
     */
	@TableField("total_amount")
	private BigDecimal totalAmount;
    /**
     * 实际总值
     */
	@TableField("actual_amount")
	private BigDecimal actualAmount;
    /**
     * 用户优惠券Id
     */
	@TableField("user_coupon_id")
	private Long userCouponId;
    /**
     * 优惠总额
     */
	@TableField("reduce_amount")
	private BigDecimal reduceAmount;
    /**
     * 支付方式 0 手动代付 1 微信支付 2 支付宝
     */
	@TableField("pay_type")
	private Integer payType;
    /**
     * 是否支付，1：已经支付过，0：没有支付过
     */
	@TableField("is_payed")
	private Integer isPayed;
    /**
     * 订单备注
     */
	private String remark;
    /**
     * 订单状态 1:待付款 2:待发货 3:待收货 4:待评价 5:成功 6:关闭，回收站，7:关闭 永久删除 11 取消订单审核中
     */
	private Integer status;
    /**
     * 配送类型
     */
	@TableField("dvy_type")
	private String dvyType;
    /**
     * 配送方式Id
     */
	@TableField("dvy_id")
	private Long dvyId;
    /**
     * 物流单号
     */
	@TableField("dvy_number")
	private String dvyNumber;
    /**
     * 订单运费
     */
	@TableField("dvy_amount")
	private BigDecimal dvyAmount;
    /**
     * 订单商品总数
     */
	@TableField("prod_num")
	private Integer prodNum;
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
    /**
     * 付款时间
     */
	@TableField("pay_time")
	private Date payTime;
    /**
     * 发货时间
     */
	@TableField("dvy_time")
	private Date dvyTime;
    /**
     * 完成时间
     */
	@TableField("finish_time")
	private Date finishTime;
    /**
     * 取消时间
     */
	@TableField("cancel_time")
	private Date cancelTime;
    /**
     * 0:默认,1:在处理,2:处理完成
     */
	@TableField("refund_status")
	private Integer refundStatus;
    /**
     * 订单关闭原因 1-超时未支付 2-退款关闭 4-买家取消 15-已通过货到付款交易
     */
	@TableField("close_type")
	private Integer closeType;


	public Long getOrderId() {
		return orderId;
	}

	public Order setOrderId(Long orderId) {
		this.orderId = orderId;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public Order setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public String getProdName() {
		return prodName;
	}

	public Order setProdName(String prodName) {
		this.prodName = prodName;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public Order setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public Order setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public Order setOrderType(Integer orderType) {
		this.orderType = orderType;
		return this;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public Order setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}

	public BigDecimal getActualAmount() {
		return actualAmount;
	}

	public Order setActualAmount(BigDecimal actualAmount) {
		this.actualAmount = actualAmount;
		return this;
	}

	public Long getUserCouponId() {
		return userCouponId;
	}

	public Order setUserCouponId(Long userCouponId) {
		this.userCouponId = userCouponId;
		return this;
	}

	public BigDecimal getReduceAmount() {
		return reduceAmount;
	}

	public Order setReduceAmount(BigDecimal reduceAmount) {
		this.reduceAmount = reduceAmount;
		return this;
	}

	public Integer getPayType() {
		return payType;
	}

	public Order setPayType(Integer payType) {
		this.payType = payType;
		return this;
	}

	public Integer getIsPayed() {
		return isPayed;
	}

	public Order setIsPayed(Integer isPayed) {
		this.isPayed = isPayed;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public Order setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public Order setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public String getDvyType() {
		return dvyType;
	}

	public Order setDvyType(String dvyType) {
		this.dvyType = dvyType;
		return this;
	}

	public Long getDvyId() {
		return dvyId;
	}

	public Order setDvyId(Long dvyId) {
		this.dvyId = dvyId;
		return this;
	}

	public String getDvyNumber() {
		return dvyNumber;
	}

	public Order setDvyNumber(String dvyNumber) {
		this.dvyNumber = dvyNumber;
		return this;
	}

	public BigDecimal getDvyAmount() {
		return dvyAmount;
	}

	public Order setDvyAmount(BigDecimal dvyAmount) {
		this.dvyAmount = dvyAmount;
		return this;
	}

	public Integer getProdNum() {
		return prodNum;
	}

	public Order setProdNum(Integer prodNum) {
		this.prodNum = prodNum;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Order setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Order setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public Date getPayTime() {
		return payTime;
	}

	public Order setPayTime(Date payTime) {
		this.payTime = payTime;
		return this;
	}

	public Date getDvyTime() {
		return dvyTime;
	}

	public Order setDvyTime(Date dvyTime) {
		this.dvyTime = dvyTime;
		return this;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public Order setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
		return this;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public Order setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
		return this;
	}

	public Integer getRefundStatus() {
		return refundStatus;
	}

	public Order setRefundStatus(Integer refundStatus) {
		this.refundStatus = refundStatus;
		return this;
	}

	public Integer getCloseType() {
		return closeType;
	}

	public Order setCloseType(Integer closeType) {
		this.closeType = closeType;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.orderId;
	}

}
