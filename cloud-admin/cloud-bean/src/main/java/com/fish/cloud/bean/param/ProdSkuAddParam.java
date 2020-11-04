package com.fish.cloud.bean.param;

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
 * 单品SKU
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
@Data
public class ProdSkuAddParam {
    /**
     * 商品Id
     */
    private Long prodId;
    /**
     * 商品条码
     */
	private String barcode;
    /**
     * sku名称
     */
	private String skuName;
    /**
     * 原价
     */
	private BigDecimal oriPrice;
    /**
     * 价格
     */
	private BigDecimal price;
    /**
     * 实际库存
     */
	private Integer stock;
}
