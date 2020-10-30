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
 * 订单项
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_order_item")
public class OrderItem extends Model<OrderItem> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单项Id
     */
	@TableId(value="order_item_id", type= IdType.AUTO)
	private Long orderItemId;
    /**
     * 订单Id
     */
	@TableField("order_id")
	private Long orderId;
    /**
     * 商品Id
     */
	@TableField("prod_id")
	private Long prodId;
    /**
     * 商品SkuId
     */
	@TableField("sku_id")
	private Long skuId;
    /**
     * 商品名称
     */
	@TableField("prod_name")
	private String prodName;
    /**
     * sku名称
     */
	@TableField("sku_name")
	private String skuName;
    /**
     * 商品主图片路径
     */
	@TableField("prod_img")
	private String prodImg;
    /**
     * sku图片路径
     */
	@TableField("sku_img")
	private String skuImg;
    /**
     * 商品个数
     */
	private Integer num;
    /**
     * 商品价格
     */
	private BigDecimal price;
    /**
     * 商品总金额
     */
	@TableField("total_amount")
	private BigDecimal totalAmount;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 评论状态： 0 未评价  1 已评价
     */
	@TableField("comment_status")
	private Integer commentStatus;
    /**
     * 用户Id
     */
	@TableField("user_id")
	private String userId;


	public Long getOrderItemId() {
		return orderItemId;
	}

	public OrderItem setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
		return this;
	}

	public Long getOrderId() {
		return orderId;
	}

	public OrderItem setOrderId(Long orderId) {
		this.orderId = orderId;
		return this;
	}

	public Long getProdId() {
		return prodId;
	}

	public OrderItem setProdId(Long prodId) {
		this.prodId = prodId;
		return this;
	}

	public Long getSkuId() {
		return skuId;
	}

	public OrderItem setSkuId(Long skuId) {
		this.skuId = skuId;
		return this;
	}

	public String getProdName() {
		return prodName;
	}

	public OrderItem setProdName(String prodName) {
		this.prodName = prodName;
		return this;
	}

	public String getSkuName() {
		return skuName;
	}

	public OrderItem setSkuName(String skuName) {
		this.skuName = skuName;
		return this;
	}

	public String getProdImg() {
		return prodImg;
	}

	public OrderItem setProdImg(String prodImg) {
		this.prodImg = prodImg;
		return this;
	}

	public String getSkuImg() {
		return skuImg;
	}

	public OrderItem setSkuImg(String skuImg) {
		this.skuImg = skuImg;
		return this;
	}

	public Integer getNum() {
		return num;
	}

	public OrderItem setNum(Integer num) {
		this.num = num;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public OrderItem setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public OrderItem setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public OrderItem setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Integer getCommentStatus() {
		return commentStatus;
	}

	public OrderItem setCommentStatus(Integer commentStatus) {
		this.commentStatus = commentStatus;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public OrderItem setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.orderItemId;
	}

}
