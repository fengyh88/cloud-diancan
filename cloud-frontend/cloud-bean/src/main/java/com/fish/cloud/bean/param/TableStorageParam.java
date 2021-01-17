package com.fish.cloud.bean.param;

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
public class TableStorageParam {

    /**
     * Id
     */
	private Long tableId;

	private Integer people;
}
