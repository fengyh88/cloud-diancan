package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

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
@Data
@TableName("cloud_table")
public class Table extends Model<Table> {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
	@TableId(value="table_id", type= IdType.AUTO)
	private Long tableId;
	/**
	 * 店铺Id
	 */
	@TableField("shop_id")
	private Long shopId;
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
     * 默认是1，表示正常状态,0为禁用 -1删除 1空桌 11未支付 12已支付
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

	@Override
	protected Serializable pkVal() {
		return this.tableId;
	}

}
