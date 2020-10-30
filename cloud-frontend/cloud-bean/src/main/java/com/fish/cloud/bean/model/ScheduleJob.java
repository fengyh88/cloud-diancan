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
 * 定时任务
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_schedule_job")
public class ScheduleJob extends Model<ScheduleJob> {

    private static final long serialVersionUID = 1L;

    /**
     * 任务Id
     */
	@TableId(value="job_id", type= IdType.AUTO)
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
     * cron表达式
     */
	@TableField("cron_expression")
	private String cronExpression;
    /**
     * 备注
     */
	private String remark;
    /**
     * 任务状态  0：正常  1：暂停
     */
	private Integer status;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;


	public Long getJobId() {
		return jobId;
	}

	public ScheduleJob setJobId(Long jobId) {
		this.jobId = jobId;
		return this;
	}

	public String getBeanName() {
		return beanName;
	}

	public ScheduleJob setBeanName(String beanName) {
		this.beanName = beanName;
		return this;
	}

	public String getMethodName() {
		return methodName;
	}

	public ScheduleJob setMethodName(String methodName) {
		this.methodName = methodName;
		return this;
	}

	public String getParams() {
		return params;
	}

	public ScheduleJob setParams(String params) {
		this.params = params;
		return this;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public ScheduleJob setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public ScheduleJob setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public ScheduleJob setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public ScheduleJob setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.jobId;
	}

}
