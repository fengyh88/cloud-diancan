package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class UserAddrAddParam {
    @ApiModelProperty(name = "addrId")
    private String addrId;
    @ApiModelProperty(name = "收货人")
    private String receiver;
    @ApiModelProperty(name = "联系电话")
    private String mobile;
    @ApiModelProperty(name = "所在地区，省")
    private Long provinceId;
    @ApiModelProperty(name = "所在地区，省")
    private String province;
    @ApiModelProperty(name = "所在地区，市")
    private Long cityId;
    @ApiModelProperty(name = "所在地区，市")
    private String city;
    @ApiModelProperty(name = "所在地区，区")
    private Long areaId;
    @ApiModelProperty(name = "所在地区，区")
    private String area;
    @ApiModelProperty(name = "详细地址")
    private String addr;
    @ApiModelProperty(name = "是否是默认地址：0=否，1=是'")
    private Integer isDefault;
}
