package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色与菜单对应关系
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@TableName("cloud_role_menu")
public class RoleMenu extends Model<RoleMenu> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 角色Id
     */
	@TableField("role_id")
	private Long roleId;
    /**
     * 菜单Id
     */
	@TableField("menu_id")
	private Long menuId;


	public Long getId() {
		return id;
	}

	public RoleMenu setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getRoleId() {
		return roleId;
	}

	public RoleMenu setRoleId(Long roleId) {
		this.roleId = roleId;
		return this;
	}

	public Long getMenuId() {
		return menuId;
	}

	public RoleMenu setMenuId(Long menuId) {
		this.menuId = menuId;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
