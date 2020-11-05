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
public class TableParam {
    /**
     * 关键词
     */
	private String keywords;
}
