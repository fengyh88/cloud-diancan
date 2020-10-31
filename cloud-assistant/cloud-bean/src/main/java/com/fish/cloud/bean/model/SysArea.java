package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_sys_area")
public class SysArea extends Model<SysArea> {

    private static final long serialVersionUID = 1L;

	@TableId(value="area_id", type= IdType.AUTO)
	private Long areaId;
	@TableField("area_name")
	private String areaName;
	@TableField("p_id")
	private Long pId;
	private Integer grade;


	public Long getAreaId() {
		return areaId;
	}

	public SysArea setAreaId(Long areaId) {
		this.areaId = areaId;
		return this;
	}

	public String getAreaName() {
		return areaName;
	}

	public SysArea setAreaName(String areaName) {
		this.areaName = areaName;
		return this;
	}

	public Long getPId() {
		return pId;
	}

	public SysArea setPId(Long pId) {
		this.pId = pId;
		return this;
	}

	public Integer getGrade() {
		return grade;
	}

	public SysArea setGrade(Integer grade) {
		this.grade = grade;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.areaId;
	}

}