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
 * 退款单
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_refund")
public class Refund extends Model<Refund> {

    private static final long serialVersionUID = 1L;

    /**
     * 记录Id
     */
	@TableId(value="refund_id", type= IdType.AUTO)
	private Long refundId;
    /**
     * 店铺Id
     */
	@TableField("shop_id")
	private Long shopId;
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
     * 订单总金额
     */
	@TableField("order_amount")
	private Double orderAmount;
    /**
     * 订单项ID 全部退款是0
     */
	@TableField("order_item_id")
	private Long orderItemId;
    /**
     * 退款流水号
     */
	@TableField("refund_number")
	private String refundNumber;
    /**
     * 订单支付流水号
     */
	@TableField("flow_trade_number")
	private String flowTradeNumber;
    /**
     * 第三方退款单号(微信退款单号)
     */
	@TableField("out_refund_number")
	private String outRefundNumber;
    /**
     * 订单支付方式 1 微信支付 2 支付宝
     */
	@TableField("pay_type")
	private Integer payType;
    /**
     * 订单支付名称
     */
	@TableField("pay_type_name")
	private String payTypeName;
    /**
     * 买家Id
     */
	@TableField("user_id")
	private String userId;
    /**
     * 退货数量
     */
	@TableField("prod_num")
	private Integer prodNum;
    /**
     * 退款金额
     */
	@TableField("refund_amount")
	private BigDecimal refundAmount;
    /**
     * 处理状态:1为待审核,2为同意,3为不同意
     */
	@TableField("refund_status")
	private Integer refundStatus;
    /**
     * 处理退款状态: 0:退款处理中 1:退款成功 -1:退款失败
     */
	@TableField("return_money_status")
	private Integer returnMoneyStatus;
    /**
     * 申请类型:1,仅退款,2退款退货
     */
	@TableField("apply_type")
	private Integer applyType;
    /**
     * 申请时间
     */
	@TableField("apply_time")
	private Date applyTime;
    /**
     * 卖家处理时间
     */
	@TableField("handle_time")
	private Date handleTime;
    /**
     * 退款时间
     */
	@TableField("refund_time")
	private Date refundTime;
    /**
     * 文件凭证json
     */
	private String imgs;
    /**
     * 买家申请原因
     */
	@TableField("buyer_msg")
	private String buyerMsg;
    /**
     * 卖家备注
     */
	@TableField("seller_msg")
	private String sellerMsg;
    /**
     * 物流公司名称
     */
	@TableField("dvy_name")
	private String dvyName;
    /**
     * 物流单号
     */
	@TableField("dvy_number")
	private String dvyNumber;
    /**
     * 发货时间
     */
	@TableField("dvy_time")
	private Date dvyTime;
    /**
     * 收货时间
     */
	@TableField("receive_time")
	private Date receiveTime;
    /**
     * 收货备注
     */
	@TableField("receive_remark")
	private String receiveRemark;


	public Long getRefundId() {
		return refundId;
	}

	public Refund setRefundId(Long refundId) {
		this.refundId = refundId;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public Refund setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Long getOrderId() {
		return orderId;
	}

	public Refund setOrderId(Long orderId) {
		this.orderId = orderId;
		return this;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public Refund setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public Refund setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
		return this;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public Refund setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
		return this;
	}

	public String getRefundNumber() {
		return refundNumber;
	}

	public Refund setRefundNumber(String refundNumber) {
		this.refundNumber = refundNumber;
		return this;
	}

	public String getFlowTradeNumber() {
		return flowTradeNumber;
	}

	public Refund setFlowTradeNumber(String flowTradeNumber) {
		this.flowTradeNumber = flowTradeNumber;
		return this;
	}

	public String getOutRefundNumber() {
		return outRefundNumber;
	}

	public Refund setOutRefundNumber(String outRefundNumber) {
		this.outRefundNumber = outRefundNumber;
		return this;
	}

	public Integer getPayType() {
		return payType;
	}

	public Refund setPayType(Integer payType) {
		this.payType = payType;
		return this;
	}

	public String getPayTypeName() {
		return payTypeName;
	}

	public Refund setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public Refund setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public Integer getProdNum() {
		return prodNum;
	}

	public Refund setProdNum(Integer prodNum) {
		this.prodNum = prodNum;
		return this;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public Refund setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
		return this;
	}

	public Integer getRefundStatus() {
		return refundStatus;
	}

	public Refund setRefundStatus(Integer refundStatus) {
		this.refundStatus = refundStatus;
		return this;
	}

	public Integer getReturnMoneyStatus() {
		return returnMoneyStatus;
	}

	public Refund setReturnMoneyStatus(Integer returnMoneyStatus) {
		this.returnMoneyStatus = returnMoneyStatus;
		return this;
	}

	public Integer getApplyType() {
		return applyType;
	}

	public Refund setApplyType(Integer applyType) {
		this.applyType = applyType;
		return this;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public Refund setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
		return this;
	}

	public Date getHandleTime() {
		return handleTime;
	}

	public Refund setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
		return this;
	}

	public Date getRefundTime() {
		return refundTime;
	}

	public Refund setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
		return this;
	}

	public String getImgs() {
		return imgs;
	}

	public Refund setImgs(String imgs) {
		this.imgs = imgs;
		return this;
	}

	public String getBuyerMsg() {
		return buyerMsg;
	}

	public Refund setBuyerMsg(String buyerMsg) {
		this.buyerMsg = buyerMsg;
		return this;
	}

	public String getSellerMsg() {
		return sellerMsg;
	}

	public Refund setSellerMsg(String sellerMsg) {
		this.sellerMsg = sellerMsg;
		return this;
	}

	public String getDvyName() {
		return dvyName;
	}

	public Refund setDvyName(String dvyName) {
		this.dvyName = dvyName;
		return this;
	}

	public String getDvyNumber() {
		return dvyNumber;
	}

	public Refund setDvyNumber(String dvyNumber) {
		this.dvyNumber = dvyNumber;
		return this;
	}

	public Date getDvyTime() {
		return dvyTime;
	}

	public Refund setDvyTime(Date dvyTime) {
		this.dvyTime = dvyTime;
		return this;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public Refund setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
		return this;
	}

	public String getReceiveRemark() {
		return receiveRemark;
	}

	public Refund setReceiveRemark(String receiveRemark) {
		this.receiveRemark = receiveRemark;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.refundId;
	}

}
