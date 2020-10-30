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
 * 单品SKU
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Data
@TableName("cloud_prod_sku")
public class ProdSku extends Model<ProdSku> {

    private static final long serialVersionUID = 1L;

    /**
     * 单品Id
     */
	@TableId(value="sku_id", type= IdType.AUTO)
	private Long skuId;
    /**
     * 商品Id
     */
	@TableField("prod_id")
	private Long prodId;
    /**
     * 店铺Id
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 商品条码
     */
	private String barcode;
    /**
     * sku名称
     */
	@TableField("sku_name")
	private String skuName;
    /**
     * 原价
     */
	@TableField("ori_price")
	private BigDecimal oriPrice;
    /**
     * 价格
     */
	private BigDecimal price;
    /**
     * 单位
     */
	private String unit;
    /**
     * 商品在付款减库存的状态下，该sku上未付款的订单数量
     */
	@TableField("v_stock")
	private Integer vStock;
    /**
     * 实际库存
     */
	private Integer stock;
    /**
     * 主图
     */
	private String img;
    /**
     * 0 禁用 1 启用 -1 已删除
     */
	private Integer status;
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
     * 版本号
     */
	private Integer version;

	@Override
	protected Serializable pkVal() {
		return this.skuId;
	}

}
