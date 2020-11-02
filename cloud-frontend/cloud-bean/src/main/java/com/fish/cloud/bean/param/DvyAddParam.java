package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@ApiModel
@Data
public class DvyAddParam {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long dvyId;
    /**
     * 编码
     */
    @ApiModelProperty(value = "编码")
    private String dvyCode;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String dvyName;
    /**
     * 运费
     */
    @ApiModelProperty(value = "运费")
    private BigDecimal dvyAmount;

    /**
     * 指定条件包邮项Id
     */
    @ApiModelProperty(value = "指定条件包邮项Id")
    private Long freeId;

}
