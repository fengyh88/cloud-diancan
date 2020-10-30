package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.math.BigDecimal;
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
 * 会员等级
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@ApiModel
@Data
@TableName("cloud_mem_grade")
public class MemGrade extends Model<MemGrade> {

    private static final long serialVersionUID = 1L;

    /**
     * grade_Id
     */
	@ApiModelProperty(value = "Id")
	@TableId(value="grade_id", type= IdType.AUTO)
	private Long gradeId;
    /**
     * 店铺ID 0为全局
     */
	@ApiModelProperty(value = "店铺ID 0为全局")
	@TableField("shop_id")
	private Long shopId;

	@ApiModelProperty(value = "等级 1普通 2 ")
	private Integer grade;
    /**
     * 等级名称
     */
	@ApiModelProperty(value = "等级名称")
	@TableField("grade_name")
	private String gradeName;
    /**
     * 图片
     */
	@ApiModelProperty(value = "图片")
	private String img;
    /**
     * 简要描述
     */
	@ApiModelProperty(value = "简要描述")
	private String brief;
    /**
     * 会员完成订单金额满足则升级
     */
	@ApiModelProperty(value = "会员完成订单金额满足则升级")
	private BigDecimal money;
    /**
     * 折扣
     */
    @ApiModelProperty(value = "折扣")
	private BigDecimal discount;
    /**
     * 状态 0禁用 1启用 -1删除
     */
	@ApiModelProperty(value = "状态 0禁用 1启用 -1删除")
	private Integer status;
    /**
     * 建立时间
     */
	@ApiModelProperty(value = "建立时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@TableField("create_time")
	private Date createTime;

	@Override
	protected Serializable pkVal() {
		return this.gradeId;
	}

}
