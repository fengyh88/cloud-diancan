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
 * 呼叫表
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@TableName("cloud_call")
@Data
@NoArgsConstructor
public class Call extends Model<Call> {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 店铺Id 0表示全局公告
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 用户Id
     */
	@TableField("user_id")
	private Long userId;
    /**
     * 桌号Id
     */
	@TableField("table_id")
	private Long tableId;
    /**
     * 公告标题
     */
	private String title;
    /**
     * 公告内容
     */
	private String content;
    /**
     * 状态(1:呼叫 2:已读 0:过期)
     */
	private Integer status;
    /**
     * 已读员工Id
     */
	@TableField("emp_id")
	private Long empId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;

	/**
	 * 创建时间
	 */
	@TableField("update_time")
	private Date updateTime;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
