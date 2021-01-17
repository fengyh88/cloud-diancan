package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author quanyu
 * @date 2020/12/03
 */
@ApiModel(value = "菜单删除入参", description = "菜单管理界面删除入参")
@Data
public class SysPermissionChangeStatusInput {

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID", required = true)
    @NotNull(message = "主键ID题不能为空")
    private Long id;
    /**
     * 菜单状态
     */
    @ApiModelProperty(value = "菜单状态", required = true)
    @NotNull(message = "菜单状态不能为空")
    private Boolean deleteFlag;
}
