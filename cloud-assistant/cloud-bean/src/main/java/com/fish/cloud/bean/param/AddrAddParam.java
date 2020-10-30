package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddrAddParam {
    @ApiModelProperty(name = "收货人")
    private String receiver;
    @ApiModelProperty(name = "联系电话")
    private String mobile;
    @ApiModelProperty(name = "所在地区，省")
    private long provinceId;
    @ApiModelProperty(name = "所在地区，市")
    private long cityId;
    @ApiModelProperty(name = "所在地区，区")
    private long districtId;
    @ApiModelProperty(name = "详细地址")
    private String detail;
    @ApiModelProperty(name = "是否是默认地址：0=否，1=是'")
    private long isDefault;
}
