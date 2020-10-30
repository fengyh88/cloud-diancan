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
 * 员工
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
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
	private String pic;
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


	public Long getEmpId() {
		return empId;
	}

	public Emp setEmpId(Long empId) {
		this.empId = empId;
		return this;
	}

	public String getEmpNumber() {
		return empNumber;
	}

	public Emp setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
		return this;
	}

	public String getEmpName() {
		return empName;
	}

	public Emp setEmpName(String empName) {
		this.empName = empName;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Emp setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Emp setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public Emp setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public String getGender() {
		return gender;
	}

	public Emp setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Emp setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public String getPic() {
		return pic;
	}

	public Emp setPic(String pic) {
		this.pic = pic;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public Emp setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Long getDeptId() {
		return deptId;
	}

	public Emp setDeptId(Long deptId) {
		this.deptId = deptId;
		return this;
	}

	public Long getDutyId() {
		return dutyId;
	}

	public Emp setDutyId(Long dutyId) {
		this.dutyId = dutyId;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public Emp setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Emp setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Emp setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.empId;
	}

}
