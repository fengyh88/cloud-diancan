package com.fish.cloud.bean.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

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
public class TableDto {

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
	 * 生成的二维码图片路径
	 */
	private String barcode;
    /**
     * 默认是1，1为正常（空桌）11为就餐 0为禁用状态 -1删除状态
     */
	private Integer status;
    /**
     * 顺序
     */
	private Integer seq;

}
