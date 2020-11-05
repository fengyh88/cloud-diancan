package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 台桌
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@ApiModel
@Data
public class TableAddParam {

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
     * 顺序
     */
	private Integer seq;

}
