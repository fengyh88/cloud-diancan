package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 订单项
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
@Data
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
     * 用户Id
     */
	@TableField("user_id")
	private String userId;
    /**
     * 台桌Id
     */
	@TableField("table_id")
	private Long tableId;
    /**
     * 商品Id
     */
	@TableField("prod_id")
	private Long prodId;
    /**
     * 商品名称
     */
	@TableField("prod_name")
	private String prodName;
    /**
     * 商品主图片路径
     */
	@TableField("prod_img")
	private String prodImg;
    /**
     * 商品属性JSON
     */
	@TableField("prod_prop")
	private String prodProp;
    /**
     * 商品SkuId
     */
	@TableField("sku_id")
	private Long skuId;
    /**
     * sku名称
     */
	@TableField("sku_name")
	private String skuName;
    /**
     * sku主图片路径
     */
	@TableField("sku_img")
	private String skuImg;
    /**
     * 销售属性组合JSON 格式是p1:v1;p2:v2
     */
	@TableField("sku_prop")
	private String skuProp;
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
     * 备注
     */
	private String remark;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;

	/**
	 * 状态 1正常 2出餐 -1删除
	 */
	private Integer status;

	@Override
	protected Serializable pkVal() {
		return this.orderItemId;
	}

}
