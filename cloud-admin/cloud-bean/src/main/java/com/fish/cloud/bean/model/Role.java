package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Data
@TableName("cloud_role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

	@TableId(value="role_id", type= IdType.AUTO)
	private Long roleId;
    /**
     * 角色名称
     */
	@TableField("role_name")
	private String roleName;
    /**
     * 店铺Id
     */
	@TableField("shop_id")
	private String shopId;
    /**
     * 备注
     */
	private String remark;
	/**
	 * 状态  0：禁用   1：启用
	 */
	private Integer status;
    /**
     * 创建者Id
     */
	@TableField("created_by")
	private Long createdBy;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;


	@Override
	protected Serializable pkVal() {
		return this.roleId;
	}

}
