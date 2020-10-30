package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Data
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
	private String shopId;
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

	@Override
	protected Serializable pkVal() {
		return this.orderId;
	}

}
