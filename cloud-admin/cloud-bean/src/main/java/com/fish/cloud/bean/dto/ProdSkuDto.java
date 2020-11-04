package com.fish.cloud.bean.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 单品SKU
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
@Data
public class ProdSkuDto {
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
     * 销售属性组合JSON 格式是p1:v1;p2:v2
     */
	@TableField("sku_prop")
	private String skuProp;
    /**
     * sku名称
     */
	@TableField("sku_name")
	private String skuName;
    /**
     * 商品名称
     */
	@TableField("prod_name")
	private String prodName;
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

	@ApiModelProperty(value = "商品Sku主图片地址")
	private String prodSkuImgUrl;
}
