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
 * 购物车
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_cart")
public class Cart extends Model<Cart> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="cart_id", type= IdType.AUTO)
	private Long cartId;
    /**
     * 店铺Id
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 用户Id
     */
	@TableField("user_id")
	private String userId;
    /**
     * 商品Id
     */
	@TableField("prod_id")
	private Long prodId;
    /**
     * SkuId
     */
	@TableField("sku_id")
	private Long skuId;
    /**
     * 购物车商品个数
     */
	private Integer num;
    /**
     * 购物时间
     */
	@TableField("cart_time")
	private Date cartTime;


	public Long getCartId() {
		return cartId;
	}

	public Cart setCartId(Long cartId) {
		this.cartId = cartId;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public Cart setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public Cart setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public Long getProdId() {
		return prodId;
	}

	public Cart setProdId(Long prodId) {
		this.prodId = prodId;
		return this;
	}

	public Long getSkuId() {
		return skuId;
	}

	public Cart setSkuId(Long skuId) {
		this.skuId = skuId;
		return this;
	}

	public Integer getNum() {
		return num;
	}

	public Cart setNum(Integer num) {
		this.num = num;
		return this;
	}

	public Date getCartTime() {
		return cartTime;
	}

	public Cart setCartTime(Date cartTime) {
		this.cartTime = cartTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.cartId;
	}

}
