package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 系统字典kv
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
@Data
@TableName("cloud_sys_dic_kv")
public class SysDicKv extends Model<SysDicKv> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 字典编码
     */
	@TableField("dic_code")
	private String dicCode;
    /**
     * key
     */
	private String key;
    /**
     * value
     */
	private String value;
    /**
     * 备注
     */
	private String remark;
    /**
     * 店铺Id 0表示全局配置
     */
	@TableField("shop_id")
	private Long shopId;
	/**
	 * 状态  0：禁用   1：启用
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
