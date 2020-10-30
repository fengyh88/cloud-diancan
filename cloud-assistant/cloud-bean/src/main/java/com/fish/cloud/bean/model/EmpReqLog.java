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
 * 后台请求日志
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_emp_req_log")
public class EmpReqLog extends Model<EmpReqLog> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 用户Id
     */
	@TableField("emp_id")
	private String empId;
    /**
     * 用户名
     */
	@TableField("user_name")
	private String userName;
    /**
     * IP地址
     */
	private String ip;
    /**
     * 用户操作
     */
	private String oper;
    /**
     * 请求方法
     */
	private String method;
    /**
     * 请求参数
     */
	private String params;
    /**
     * 执行时长(毫秒)
     */
	private Long time;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;


	public Long getId() {
		return id;
	}

	public EmpReqLog setId(Long id) {
		this.id = id;
		return this;
	}

	public String getEmpId() {
		return empId;
	}

	public EmpReqLog setEmpId(String empId) {
		this.empId = empId;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public EmpReqLog setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getIp() {
		return ip;
	}

	public EmpReqLog setIp(String ip) {
		this.ip = ip;
		return this;
	}

	public String getOper() {
		return oper;
	}

	public EmpReqLog setOper(String oper) {
		this.oper = oper;
		return this;
	}

	public String getMethod() {
		return method;
	}

	public EmpReqLog setMethod(String method) {
		this.method = method;
		return this;
	}

	public String getParams() {
		return params;
	}

	public EmpReqLog setParams(String params) {
		this.params = params;
		return this;
	}

	public Long getTime() {
		return time;
	}

	public EmpReqLog setTime(Long time) {
		this.time = time;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public EmpReqLog setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
