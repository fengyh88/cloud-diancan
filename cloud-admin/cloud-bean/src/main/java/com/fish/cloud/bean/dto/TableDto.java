package com.fish.cloud.bean.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
public class TableDto implements IDtoDic{

    /**
     * Id
     */
	private Long tableId;
	/**
	 * 店铺Id
	 */
	private Long shopId;
    /**
     * 台桌名称
     */
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
	private Date createdTime;

}
