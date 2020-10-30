package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 员工角色
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_emp_role")
public class EmpRole extends Model<EmpRole> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 员工Id
     */
	@TableField("emp_id")
	private String empId;
    /**
     * 角色Id
     */
	@TableField("role_id")
	private Long roleId;


	public Long getId() {
		return id;
	}

	public EmpRole setId(Long id) {
		this.id = id;
		return this;
	}

	public String getEmpId() {
		return empId;
	}

	public EmpRole setEmpId(String empId) {
		this.empId = empId;
		return this;
	}

	public Long getRoleId() {
		return roleId;
	}

	public EmpRole setRoleId(Long roleId) {
		this.roleId = roleId;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
