package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 优惠券
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@ApiModel
@Data
public class CouponParam {
    @ApiModelProperty(value = "优惠券类型： 0全部 1折扣 2满减")
	private Integer discountType;
	@ApiModelProperty(value = "是否过期： 0全部 1未过期 2已过期")
	private Integer expired;
	@ApiModelProperty(value = "状态： 0全部 1禁用 2启用")
	private Integer status;

}
