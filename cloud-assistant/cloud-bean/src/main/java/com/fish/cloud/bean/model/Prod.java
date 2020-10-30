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
 * 商品
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_prod")
public class Prod extends Model<Prod> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品Id
     */
	@TableId(value="prod_id", type= IdType.AUTO)
	private Long prodId;
    /**
     * 商品编码
     */
	@TableField("prod_code")
	private String prodCode;
    /**
     * 商品名称
     */
	@TableField("prod_name")
	private String prodName;
    /**
     * 拼音简码
     */
	private String pinyin;
    /**
     * 店铺Id
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 商品分类
     */
	@TableField("cate_id")
	private Long cateId;
    /**
     * 品牌Id
     */
	@TableField("brand_id")
	private Long brandId;
    /**
     * 原价
     */
	@TableField("ori_price")
	private BigDecimal oriPrice;
    /**
     * 现价
     */
	private BigDecimal price;
    /**
     * 会员价
     */
	@TableField("mem_price")
	private BigDecimal memPrice;
    /**
     * 单位
     */
	private String unit;
    /**
     * 简要描述,卖点等
     */
	private String brief;
    /**
     * 详细描述
     */
	private String content;
    /**
     * 销量
     */
	private Integer sold;
    /**
     * 库存
     */
	private Integer stock;
    /**
     * 默认是1，表示正常状态, -1表示删除, 0下架
     */
	private Integer status;
    /**
     * 主图
     */
	private String img;
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
     * 上架时间
     */
	@TableField("puton_time")
	private Date putonTime;
    /**
     * 版本 乐观锁
     */
	private Integer version;


	public Long getProdId() {
		return prodId;
	}

	public Prod setProdId(Long prodId) {
		this.prodId = prodId;
		return this;
	}

	public String getProdCode() {
		return prodCode;
	}

	public Prod setProdCode(String prodCode) {
		this.prodCode = prodCode;
		return this;
	}

	public String getProdName() {
		return prodName;
	}

	public Prod setProdName(String prodName) {
		this.prodName = prodName;
		return this;
	}

	public String getPinyin() {
		return pinyin;
	}

	public Prod setPinyin(String pinyin) {
		this.pinyin = pinyin;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public Prod setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Long getCateId() {
		return cateId;
	}

	public Prod setCateId(Long cateId) {
		this.cateId = cateId;
		return this;
	}

	public Long getBrandId() {
		return brandId;
	}

	public Prod setBrandId(Long brandId) {
		this.brandId = brandId;
		return this;
	}

	public BigDecimal getOriPrice() {
		return oriPrice;
	}

	public Prod setOriPrice(BigDecimal oriPrice) {
		this.oriPrice = oriPrice;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Prod setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public BigDecimal getMemPrice() {
		return memPrice;
	}

	public Prod setMemPrice(BigDecimal memPrice) {
		this.memPrice = memPrice;
		return this;
	}

	public String getUnit() {
		return unit;
	}

	public Prod setUnit(String unit) {
		this.unit = unit;
		return this;
	}

	public String getBrief() {
		return brief;
	}

	public Prod setBrief(String brief) {
		this.brief = brief;
		return this;
	}

	public String getContent() {
		return content;
	}

	public Prod setContent(String content) {
		this.content = content;
		return this;
	}

	public Integer getSold() {
		return sold;
	}

	public Prod setSold(Integer sold) {
		this.sold = sold;
		return this;
	}

	public Integer getStock() {
		return stock;
	}

	public Prod setStock(Integer stock) {
		this.stock = stock;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public Prod setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public String getImg() {
		return img;
	}

	public Prod setImg(String img) {
		this.img = img;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Prod setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Prod setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public Date getPutonTime() {
		return putonTime;
	}

	public Prod setPutonTime(Date putonTime) {
		this.putonTime = putonTime;
		return this;
	}

	public Integer getVersion() {
		return version;
	}

	public Prod setVersion(Integer version) {
		this.version = version;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.prodId;
	}

}
