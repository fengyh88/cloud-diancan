package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author quanyu
 * @date 2020/12/03
 */
@ApiModel(value = "菜单查询入参", description = "菜单管理界面查询入参")
@Data
public class SysPermissionListInput {

    /**
     * 菜单标题
     */
    @ApiModelProperty(value = "菜单标题")
    private String title;
    /**
     * 路径
     */
    @ApiModelProperty(value = "路径")
    private String url;
    /**
     * 角色编号
     */
    @ApiModelProperty(value = "角色编号")
    private String roleCode;
    /**
     * 菜单类型(0:一级菜单; 1:子菜单 2:按钮权限)
     */
    @ApiModelProperty(value = "菜单类型 0:一级菜单; 1:子菜单 2:按钮权限 默认0")
    private String menuType;
}
