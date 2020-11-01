package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
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
	private Long shopId;
	/**
	 * 台桌Id
	 */
	@TableField("table_id")
	private Long tableId;
    /**
     * 商品名称,多个商品将会以逗号隔开
     */
	@TableField("prod_name")
	private String prodName;
    /**
     * 用户Id
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
     * 实际总值
     */
	@TableField("actual_amount")
	private BigDecimal actualAmount;
    /**
     * 支付方式 1 微信支付 2 支付宝 3 现金支付
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
     * 订单状态 1：已提交 5：未支付 9:已支付 13:关闭，失败，17:完成，成功
     */
	private Integer status;
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
     * 完成时间
     */
	@TableField("complete_time")
	private Date completeTime;

	@Override
	protected Serializable pkVal() {
		return this.orderId;
	}

}
