package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

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
	 * 生成的二维码图片路径
	 */
	private String barcode;
    /**
     * 1表示正常（空桌） 0为禁用 -1删除  11就餐
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
