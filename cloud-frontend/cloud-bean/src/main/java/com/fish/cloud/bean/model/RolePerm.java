package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 角色与权限对应关系
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@TableName("cloud_role_perm")
public class RolePerm extends Model<RolePerm> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 角色Id
     */
	@TableField("role_id")
	private Long roleId;
    /**
     * 权限Id
     */
	@TableField("perm_id")
	private Long permId;


	public Long getId() {
		return id;
	}

	public RolePerm setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getRoleId() {
		return roleId;
	}

	public RolePerm setRoleId(Long roleId) {
		this.roleId = roleId;
		return this;
	}

	public Long getPermId() {
		return permId;
	}

	public RolePerm setPermId(Long permId) {
		this.permId = permId;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
