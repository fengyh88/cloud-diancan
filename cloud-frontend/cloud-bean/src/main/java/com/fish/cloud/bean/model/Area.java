package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@ApiModel
@Data
@TableName("cloud_area")
public class Area extends Model<Area> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
	@TableId(value="area_id", type= IdType.AUTO)
	private Long areaId;

	@ApiModelProperty(value = "区域名称")
	@TableField("area_name")
	private String areaName;

	@ApiModelProperty(value = "父Id")
	@TableField("p_id")
	private Long pId;

	@ApiModelProperty(value = "层级")
	private Integer grade;

	@Override
	protected Serializable pkVal() {
		return this.areaId;
	}

}
