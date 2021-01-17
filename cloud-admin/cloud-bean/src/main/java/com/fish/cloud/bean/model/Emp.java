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
 * 员工
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Data
@TableName("cloud_emp")
public class Emp extends Model<Emp> {

    private static final long serialVersionUID = 1L;

	@TableId(value="emp_id", type= IdType.AUTO)
	private Long empId;
    /**
     * 工号
     */
	@TableField("emp_number")
	private String empNumber;
    /**
     * 姓名
     */
	@TableField("emp_name")
	private String empName;
    /**
     * 密码
     */
	private String password;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 手机号
     */
	private String mobile;
    /**
     * M(男) or F(女)
     */
	private String gender;
    /**
     * 例如：2009-11-27
     */
	@TableField("birth_date")
	private Date birthDate;
    /**
     * 头像图片路径
     */
	private String img;
    /**
     * 用户所在的商城Id
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 所属部门Id
     */
	@TableField("dept_id")
	private Long deptId;
    /**
     * 岗位Id
     */
	@TableField("duty_id")
	private Long dutyId;
	/**
	 * 角色Id
	 */
	@TableField("role_id")
	private Long roleId;
    /**
     * 状态  0：禁用   1：正常
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
		return this.empId;
	}

}
