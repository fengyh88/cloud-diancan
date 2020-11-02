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
 * 商品
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
@Data
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
	@TableField("unit_id")
	private String unitId;
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
     * 默认是1 上架, -1表示删除, 0下架
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
     * 上架时间
     */
	@TableField("puton_time")
	private Date putonTime;
    /**
     * 版本 乐观锁
     */
	private Integer version;

	@Override
	protected Serializable pkVal() {
		return this.prodId;
	}

}
