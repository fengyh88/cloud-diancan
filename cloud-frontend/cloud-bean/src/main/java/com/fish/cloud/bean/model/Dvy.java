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
 * 送货方式
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@ApiModel
@Data
@TableName("cloud_dvy")
public class Dvy extends Model<Dvy> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
	@TableId(value="dvy_id", type= IdType.AUTO)
	private Long dvyId;
    /**
     * 编码
     */
	@ApiModelProperty(value = "编码")
	@TableField("dvy_code")
	private String dvyCode;
    /**
     * 名称
     */
	@ApiModelProperty(value = "名称")
	@TableField("dvy_name")
	private String dvyName;
    /**
     * 运费
     */
	@ApiModelProperty(value = "运费")
	@TableField("dvy_amount")
	private BigDecimal dvyAmount;
    /**
     * 店铺Id
     */
	@ApiModelProperty(value = "店铺Id")
	@TableField("shop_id")
	private Long shopId;
	/**
	 * 指定条件包邮项Id
	 */
	@ApiModelProperty(value = "指定条件包邮项Id")
	@TableField("free_id")
	private Long freeId;
    /**
     * 状态
     */
	@ApiModelProperty(value = "状态")
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
		return this.dvyId;
	}

}
