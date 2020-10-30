package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商品属性值
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@TableName("cloud_prod_prop_value")
public class ProdPropValue extends Model<ProdPropValue> {

    private static final long serialVersionUID = 1L;

    /**
     * 属性值Id
     */
	@TableId(value="value_id", type= IdType.AUTO)
	private Long valueId;
    /**
     * 属性值名称
     */
	@TableField("value_name")
	private String valueName;
    /**
     * 属性Id
     */
	@TableField("prop_id")
	private Long propId;


	public Long getValueId() {
		return valueId;
	}

	public ProdPropValue setValueId(Long valueId) {
		this.valueId = valueId;
		return this;
	}

	public String getValueName() {
		return valueName;
	}

	public ProdPropValue setValueName(String valueName) {
		this.valueName = valueName;
		return this;
	}

	public Long getPropId() {
		return propId;
	}

	public ProdPropValue setPropId(Long propId) {
		this.propId = propId;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.valueId;
	}

}
