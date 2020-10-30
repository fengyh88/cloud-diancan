package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
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
	private Long shopId;
    /**
     * 备注
     */
	private String remark;
    /**
     * 创建者Id
     */
	@TableField("create_by")
	private Long createBy;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;


	public Long getRoleId() {
		return roleId;
	}

	public Role setRoleId(Long roleId) {
		this.roleId = roleId;
		return this;
	}

	public String getRoleName() {
		return roleName;
	}

	public Role setRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public Role setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public Role setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public Role setCreateBy(Long createBy) {
		this.createBy = createBy;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Role setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.roleId;
	}

}
