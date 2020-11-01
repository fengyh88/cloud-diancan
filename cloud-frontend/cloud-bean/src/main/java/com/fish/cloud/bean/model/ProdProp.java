package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商品属性
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@TableName("cloud_prod_prop")
public class ProdProp extends Model<ProdProp> {

    private static final long serialVersionUID = 1L;

    /**
     * 属性Id
     */
	@TableId(value="prop_id", type= IdType.AUTO)
	private Long propId;
    /**
     * 店铺Id
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 商品分类 0表示所有分类通用
     */
	@TableField("cate_id")
	private Long cateId;
    /**
     * 1:销售属性(规格); 2:参数属性
     */
	private Integer rule;
    /**
     * 属性名称
     */
	@TableField("prop_name")
	private String propName;


	public Long getPropId() {
		return propId;
	}

	public ProdProp setPropId(Long propId) {
		this.propId = propId;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public ProdProp setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Long getCateId() {
		return cateId;
	}

	public ProdProp setCateId(Long cateId) {
		this.cateId = cateId;
		return this;
	}

	public Integer getRule() {
		return rule;
	}

	public ProdProp setRule(Integer rule) {
		this.rule = rule;
		return this;
	}

	public String getPropName() {
		return propName;
	}

	public ProdProp setPropName(String propName) {
		this.propName = propName;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.propId;
	}

}
