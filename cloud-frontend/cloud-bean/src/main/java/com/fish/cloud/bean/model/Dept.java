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
 * 部门
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_dept")
public class Dept extends Model<Dept> {

    private static final long serialVersionUID = 1L;

    /**
     * dept_Id
     */
	@TableId(value="dept_id", type= IdType.AUTO)
	private Long deptId;
    /**
     * 名称
     */
	@TableField("dept_name")
	private String deptName;
    /**
     * 父级部门
     */
	@TableField("p_id")
	private String pId;
    /**
     * 商家Id
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 建立时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;


	public Long getDeptId() {
		return deptId;
	}

	public Dept setDeptId(Long deptId) {
		this.deptId = deptId;
		return this;
	}

	public String getDeptName() {
		return deptName;
	}

	public Dept setDeptName(String deptName) {
		this.deptName = deptName;
		return this;
	}

	public String getPId() {
		return pId;
	}

	public Dept setPId(String pId) {
		this.pId = pId;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public Dept setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Dept setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Dept setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.deptId;
	}

}
