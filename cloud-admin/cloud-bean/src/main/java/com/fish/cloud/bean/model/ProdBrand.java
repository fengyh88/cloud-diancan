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
 * 品牌
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@ApiModel
@Data
@TableName("cloud_prod_brand")
public class ProdBrand extends Model<ProdBrand> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "Id")
	@TableId(value="brand_id", type= IdType.AUTO)
	private Long brandId;
    /**
     * 品牌名称
     */
	@ApiModelProperty(value = "品牌名称")
	@TableField("brand_name")
	private String brandName;
	/**
	 * 店铺Id
	 */
	@ApiModelProperty(value = "店铺Id")
	@TableField("shop_id")
	private String shopId;
    /**
     * 品牌logo
     */
	@ApiModelProperty(value = "品牌logo")
	private String logo;
    /**
     * 大图
     */
	@ApiModelProperty(value = "大图")
	private String img;
    /**
     * 品牌首字母
     */
	@ApiModelProperty(value = "品牌首字母")
	@TableField("first_char")
	private String firstChar;
    /**
     * 简要描述
     */
	@ApiModelProperty(value = "简要描述")
	private String brief;
    /**
     * 内容
     */
	@ApiModelProperty(value = "内容")
	private String content;
    /**
     * 备注
     */
	@ApiModelProperty(value = "备注")
	private String remark;
    /**
     * 顺序
     */
	@ApiModelProperty(value = "顺序")
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
	@TableField("create_time")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
    /**
     * 更新时间
     */
	@ApiModelProperty(value = "更新时间")
	@TableField("update_time")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

	@Override
	protected Serializable pkVal() {
		return this.brandId;
	}

}
