package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 商品类目
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@ApiModel
@Data
@TableName("cloud_prod_cate")
public class ProdCate extends Model<ProdCate> {

	private static final long serialVersionUID = 1L;

	/**
	 * 类目Id
	 */
	@ApiModelProperty(value = "类目Id")
	@TableId(value="cate_id", type= IdType.AUTO)
	private Long cateId;
	/**
	 * 店铺Id
	 */
	@ApiModelProperty(value = "店铺Id")
	@TableField("shop_id")
	private String shopId;
	/**
	 * 类目名称
	 */
	@ApiModelProperty(value = "类目名称")
	@TableField("cate_name")
	private String cateName;
	/**
	 * 类目图标
	 */
	@ApiModelProperty(value = "类目图标")
	private String icon;
	/**
	 * 类目的显示图片
	 */
	@ApiModelProperty(value = "类目的显示图片")
	private String img;
	/**
	 * 父节点
	 */
	@ApiModelProperty(value = "父节点")
	@TableField("p_id")
	private Long pId;
	/**
	 * 分类层级
	 */
	@ApiModelProperty(value = "分类层级")
	private Integer grade;
	/**
	 * 排序
	 */
	@ApiModelProperty(value = "排序")
	private Integer seq;
	/**
	 * 默认是1，表示正常状态,0为下线状态
	 */
	@ApiModelProperty(value = "默认是1，表示正常状态,0为下线状态")
	private Integer status;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@TableField("create_time")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@TableField("update_time")
	private Date updateTime;

	@Override
	protected Serializable pkVal() {
		return this.cateId;
	}

}