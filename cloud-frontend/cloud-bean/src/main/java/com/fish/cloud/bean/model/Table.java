package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 台桌
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@TableName("cloud_table")
public class Table extends Model<Table> {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
	@TableId(value="table_id", type= IdType.AUTO)
	private Long tableId;
    /**
     * 台桌编码
     */
	@TableField("table_code")
	private String tableCode;
    /**
     * 台桌名称
     */
	@TableField("table_name")
	private String tableName;
    /**
     * 台桌位置
     */
	private String location;
    /**
     * 人数
     */
	private Integer people;
    /**
     * 备注
     */
	private String remark;
    /**
     * 默认是1，表示正常状态,0为禁用状态 -1 删除状态 10 空桌 11 就餐 12结清
     */
	private Integer status;
    /**
     * 顺序
     */
	private Integer seq;
    /**
     * 创建时间
     */
	@TableField("created_time")
	private Date createdTime;
    /**
     * 创建者
     */
	@TableField("created_by")
	private Date createdBy;


	public Long getTableId() {
		return tableId;
	}

	public Table setTableId(Long tableId) {
		this.tableId = tableId;
		return this;
	}

	public String getTableCode() {
		return tableCode;
	}

	public Table setTableCode(String tableCode) {
		this.tableCode = tableCode;
		return this;
	}

	public String getTableName() {
		return tableName;
	}

	public Table setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}

	public String getLocation() {
		return location;
	}

	public Table setLocation(String location) {
		this.location = location;
		return this;
	}

	public Integer getPeople() {
		return people;
	}

	public Table setPeople(Integer people) {
		this.people = people;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public Table setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public Table setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Integer getSeq() {
		return seq;
	}

	public Table setSeq(Integer seq) {
		this.seq = seq;
		return this;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public Table setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
		return this;
	}

	public Date getCreatedBy() {
		return createdBy;
	}

	public Table setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.tableId;
	}

}
