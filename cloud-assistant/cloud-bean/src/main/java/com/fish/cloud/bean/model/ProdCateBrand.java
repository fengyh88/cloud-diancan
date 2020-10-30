package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 产品类目品牌映射表
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_prod_cate_brand")
public class ProdCateBrand extends Model<ProdCateBrand> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 分类Id
     */
	@TableField("cate_id")
	private Long cateId;
    /**
     * 品牌Id
     */
	@TableField("brand_id")
	private Long brandId;


	public Long getId() {
		return id;
	}

	public ProdCateBrand setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getCateId() {
		return cateId;
	}

	public ProdCateBrand setCateId(Long cateId) {
		this.cateId = cateId;
		return this;
	}

	public Long getBrandId() {
		return brandId;
	}

	public ProdCateBrand setBrandId(Long brandId) {
		this.brandId = brandId;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
