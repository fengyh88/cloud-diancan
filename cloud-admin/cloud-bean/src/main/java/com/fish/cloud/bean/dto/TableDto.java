package com.fish.cloud.bean.dto;

import com.fish.cloud.bean.annotation.Dic;
import lombok.Data;

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
     * 台桌编码
     */
	private String tableCode;
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
     * 默认是1，表示正常状态,0为禁用 -1删除 1空桌 11未支付 12已支付
     */
    @Dic(dicCode = "tableStatus")
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