package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class DutyAddParam {
    @ApiModelProperty(value = "岗位Id")
    private Long dutyId;

    @ApiModelProperty(value = "名称")
    private String dutyName;

}
