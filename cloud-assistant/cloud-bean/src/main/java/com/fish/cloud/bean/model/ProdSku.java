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
 * 单品SKU
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
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
     * 销售属性组合字符串 格式是p1:v1;p2:v2
     */
	private String properties;
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


	public Long getSkuId() {
		return skuId;
	}

	public ProdSku setSkuId(Long skuId) {
		this.skuId = skuId;
		return this;
	}

	public Long getProdId() {
		return prodId;
	}

	public ProdSku setProdId(Long prodId) {
		this.prodId = prodId;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public ProdSku setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public String getBarcode() {
		return barcode;
	}

	public ProdSku setBarcode(String barcode) {
		this.barcode = barcode;
		return this;
	}

	public String getProperties() {
		return properties;
	}

	public ProdSku setProperties(String properties) {
		this.properties = properties;
		return this;
	}

	public String getSkuName() {
		return skuName;
	}

	public ProdSku setSkuName(String skuName) {
		this.skuName = skuName;
		return this;
	}

	public String getProdName() {
		return prodName;
	}

	public ProdSku setProdName(String prodName) {
		this.prodName = prodName;
		return this;
	}

	public BigDecimal getOriPrice() {
		return oriPrice;
	}

	public ProdSku setOriPrice(BigDecimal oriPrice) {
		this.oriPrice = oriPrice;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public ProdSku setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public String getUnit() {
		return unit;
	}

	public ProdSku setUnit(String unit) {
		this.unit = unit;
		return this;
	}

	public Integer getVStock() {
		return vStock;
	}

	public ProdSku setVStock(Integer vStock) {
		this.vStock = vStock;
		return this;
	}

	public Integer getStock() {
		return stock;
	}

	public ProdSku setStock(Integer stock) {
		this.stock = stock;
		return this;
	}

	public String getImg() {
		return img;
	}

	public ProdSku setImg(String img) {
		this.img = img;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public ProdSku setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public ProdSku setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public ProdSku setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public Integer getVersion() {
		return version;
	}

	public ProdSku setVersion(Integer version) {
		this.version = version;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.skuId;
	}

}
