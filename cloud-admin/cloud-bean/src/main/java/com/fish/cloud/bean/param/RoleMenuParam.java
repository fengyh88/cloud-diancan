package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@ApiModel(value = "角色权限入参", description = "权限入参")
@Data
public class RoleMenuParam {

    /**
     * 角色编号
     */
    @ApiModelProperty(value = "角色编码", required = true)
    @NotNull(message = "角色编码不能为空")
    private Long roleId;
    /**
     * 菜单Id字符串，用英文逗号分隔
     */
    @ApiModelProperty(value = "菜单Id字符串，用英文逗号分隔(例：1001,1002,1003,1004)")
    private String menuIds;

}
