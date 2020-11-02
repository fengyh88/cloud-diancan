package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class DutyAddParam {
    @ApiModelProperty(value = "Id")
    private Long dutyId;

    @ApiModelProperty(value = "编码")
    private String dutyCode;

    @ApiModelProperty(value = "名称")
    private String dutyName;

}
