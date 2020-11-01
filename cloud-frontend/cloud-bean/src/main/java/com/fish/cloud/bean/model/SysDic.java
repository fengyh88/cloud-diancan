package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 系统字典
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
@Data
@TableName("cloud_sys_dic")
public class SysDic extends Model<SysDic> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 编码
     */
	@TableField("dic_code")
	private String dicCode;
    /**
     * 名称
     */
	@TableField("dic_name")
	private String dicName;
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
