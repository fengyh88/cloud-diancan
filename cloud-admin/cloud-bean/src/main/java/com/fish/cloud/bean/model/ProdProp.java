package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 商品属性
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Data
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
     * 属性名称
     */
	@TableField("prop_name")
	private String propName;
	/**
	 * 属性值
	 */
	@TableField("prop_value")
	private String propValue;

	/**
	 * 默认是1 正常状态,0 禁用状态 -1 删除状态
	 */
	private Integer status;

	@Override
	protected Serializable pkVal() {
		return this.propId;
	}

}
