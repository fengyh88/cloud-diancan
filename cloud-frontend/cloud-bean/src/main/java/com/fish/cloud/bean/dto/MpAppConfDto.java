package com.fish.cloud.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class MpAppConfDto {
    @ApiModelProperty(value = "名称")
    private String appName;

    @ApiModelProperty(value = "描述")
    private String appDesc;

    @ApiModelProperty(value = "版本号")
    private String appVersion;

    @ApiModelProperty(value = "logo")
    private String appLogo;
}
