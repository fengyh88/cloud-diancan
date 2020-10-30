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
 * 员工登录记录
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_emp_login_record")
public class EmpLoginRecord extends Model<EmpLoginRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 用户Id
     */
	@TableField("emp_id")
	private String empId;
    /**
     * 终端类型 1小程序 2PC Web
     */
	@TableField("app_type")
	private Integer appType;
    /**
     * IP
     */
	private String ip;
    /**
     * 时间
     */
	@TableField("create_time")
	private Date createTime;


	public Long getId() {
		return id;
	}

	public EmpLoginRecord setId(Long id) {
		this.id = id;
		return this;
	}

	public String getEmpId() {
		return empId;
	}

	public EmpLoginRecord setEmpId(String empId) {
		this.empId = empId;
		return this;
	}

	public Integer getAppType() {
		return appType;
	}

	public EmpLoginRecord setAppType(Integer appType) {
		this.appType = appType;
		return this;
	}

	public String getIp() {
		return ip;
	}

	public EmpLoginRecord setIp(String ip) {
		this.ip = ip;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public EmpLoginRecord setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
