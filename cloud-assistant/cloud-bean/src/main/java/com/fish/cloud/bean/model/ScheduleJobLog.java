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
 * 定时任务日志
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_schedule_job_log")
public class ScheduleJobLog extends Model<ScheduleJobLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 任务日志Id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 任务Id
     */
	@TableField("job_id")
	private Long jobId;
    /**
     * spring bean名称
     */
	@TableField("bean_name")
	private String beanName;
    /**
     * 方法名
     */
	@TableField("method_name")
	private String methodName;
    /**
     * 参数
     */
	private String params;
    /**
     * 任务状态    0：成功    1：失败
     */
	private Integer status;
    /**
     * 耗时(单位：毫秒)
     */
	private Integer time;
    /**
     * 失败信息
     */
	private String error;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;


	public Long getId() {
		return id;
	}

	public ScheduleJobLog setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getJobId() {
		return jobId;
	}

	public ScheduleJobLog setJobId(Long jobId) {
		this.jobId = jobId;
		return this;
	}

	public String getBeanName() {
		return beanName;
	}

	public ScheduleJobLog setBeanName(String beanName) {
		this.beanName = beanName;
		return this;
	}

	public String getMethodName() {
		return methodName;
	}

	public ScheduleJobLog setMethodName(String methodName) {
		this.methodName = methodName;
		return this;
	}

	public String getParams() {
		return params;
	}

	public ScheduleJobLog setParams(String params) {
		this.params = params;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public ScheduleJobLog setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Integer getTime() {
		return time;
	}

	public ScheduleJobLog setTime(Integer time) {
		this.time = time;
		return this;
	}

	public String getError() {
		return error;
	}

	public ScheduleJobLog setError(String error) {
		this.error = error;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public ScheduleJobLog setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
