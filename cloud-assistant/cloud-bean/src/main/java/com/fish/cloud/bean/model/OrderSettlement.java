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
 * 
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_order_settlement")
public class OrderSettlement extends Model<OrderSettlement> {

    private static final long serialVersionUID = 1L;

    /**
     * 结算单号Id
     */
	@TableId(value="settlement_id", type= IdType.AUTO)
	private Long settlementId;
    /**
     * 订单Id
     */
	@TableField("order_id")
	private Long orderId;
    /**
     * 订单流水号
     */
	@TableField("order_number")
	private String orderNumber;
    /**
     * 支付方式 1 微信支付 2 支付宝
     */
	@TableField("pay_type")
	private Integer payType;
    /**
     * 支付方式名称
     */
	@TableField("pay_type_name")
	private String payTypeName;
    /**
     * 支付金额
     */
	@TableField("pay_amount")
	private BigDecimal payAmount;
    /**
     * 支付单号
     */
	@TableField("pay_number")
	private String payNumber;
    /**
     * 支付状态
     */
	@TableField("pay_status")
	private Integer payStatus;
    /**
     * 外部订单流水号
     */
	@TableField("biz_pay_number")
	private String bizPayNumber;
    /**
     * 是否清算 0:否 1:是
     */
	@TableField("is_clear")
	private Integer isClear;
    /**
     * 清算时间
     */
	@TableField("clear_time")
	private Date clearTime;
    /**
     * 用户Id
     */
	@TableField("user_id")
	private String userId;
    /**
     * 店铺Id
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 版本号
     */
	private Integer version;


	public Long getSettlementId() {
		return settlementId;
	}

	public OrderSettlement setSettlementId(Long settlementId) {
		this.settlementId = settlementId;
		return this;
	}

	public Long getOrderId() {
		return orderId;
	}

	public OrderSettlement setOrderId(Long orderId) {
		this.orderId = orderId;
		return this;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public OrderSettlement setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public Integer getPayType() {
		return payType;
	}

	public OrderSettlement setPayType(Integer payType) {
		this.payType = payType;
		return this;
	}

	public String getPayTypeName() {
		return payTypeName;
	}

	public OrderSettlement setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
		return this;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public OrderSettlement setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
		return this;
	}

	public String getPayNumber() {
		return payNumber;
	}

	public OrderSettlement setPayNumber(String payNumber) {
		this.payNumber = payNumber;
		return this;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public OrderSettlement setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
		return this;
	}

	public String getBizPayNumber() {
		return bizPayNumber;
	}

	public OrderSettlement setBizPayNumber(String bizPayNumber) {
		this.bizPayNumber = bizPayNumber;
		return this;
	}

	public Integer getIsClear() {
		return isClear;
	}

	public OrderSettlement setIsClear(Integer isClear) {
		this.isClear = isClear;
		return this;
	}

	public Date getClearTime() {
		return clearTime;
	}

	public OrderSettlement setClearTime(Date clearTime) {
		this.clearTime = clearTime;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public OrderSettlement setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public OrderSettlement setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public OrderSettlement setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Integer getVersion() {
		return version;
	}

	public OrderSettlement setVersion(Integer version) {
		this.version = version;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.settlementId;
	}

}
