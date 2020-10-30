package com.fish.cloud.bean.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Data
@TableName("cloud_perm")
public class Perm extends Model<Perm> {

    private static final long serialVersionUID = 1L;

    /**
     * 权限编码
     */
    @TableId("perm_code")
	private String permCode;
    /**
     * 权限名称
     */
	@TableField("perm_name")
	private String permName;
    /**
     * 店铺Id
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 状态  0：禁用   1：启用
     */
	private Integer status;
    /**
     * 建立时间
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
		return this.permCode;
	}

}
