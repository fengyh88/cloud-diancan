package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 字典信息
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Data
public class SysDicKvParam {

    @ApiModelProperty(value = "编码")
    private String dicCode;

    @ApiModelProperty(value = "关键字")
	private String keywords;
}
