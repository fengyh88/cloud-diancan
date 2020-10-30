package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 店铺图
 * </p>
 *
 * @author fengyh
 * @since 2020-03-14
 */
@Data
@ApiModel
@TableName("cloud_shop_img")
public class ShopImg extends Model<ShopImg> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Id")
	@TableId(value="img_id", type= IdType.AUTO)
	private Long imgId;
	/**
	 * 图片地址
	 */
	@ApiModelProperty(value = "图片地址")
	@TableField("img_url")
	private String imgUrl;
	/**
	 * 图片类型
	 */
	@ApiModelProperty(value = "图片类型")
	@TableField("img_type")
	private String imgType;
	/**
	 * 图片大小
	 */
	@ApiModelProperty(value = "图片大小")
	@TableField("img_size")
	private Integer imgSize;
	/**
	 * 上传时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@ApiModelProperty(value = "上传时间")
	@TableField("upload_time")
	private Date uploadTime;
	/**
	 * 图片关联的表主键Id
	 */
	@ApiModelProperty(value = "图片关联的表主键Id")
	@TableField("link_id")
	private Long linkId;
	/**
	 * 1 轮播图，2 详情图)
	 */
	@ApiModelProperty(value = "1 轮播图，2 详情图)")
	@TableField("link_cate")
	private Integer linkCate;

	@Override
	protected Serializable pkVal() {
		return this.imgId;
	}

}
