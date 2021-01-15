package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Data
@NoArgsConstructor
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
	 * 台桌Id
	 */
	@TableField("table_id")
	private String tableId;
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
     * skuId
     */
	@TableField("sku_id")
	private Long skuId;
    /**
     * 商品属性JSON
     */
	@TableField("prod_prop")
	private String prodProp;
    /**
     * 购物车商品个数
     */
	private Integer num;
    /**
     * 购物时间
     */
	@TableField("cart_time")
	private Date cartTime;

	@Override
	protected Serializable pkVal() {
		return this.cartId;
	}

}
