package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 部门
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
@Data
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
	private Long pId;
    /**
     * 店铺Id
     */
	@TableField("shop_id")
	private Long shopId;
	/**
	 * 状态  0：禁用   1：启用
	 */
	private Integer status;
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

	@Override
	protected Serializable pkVal() {
		return this.deptId;
	}

}
