package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author quanyu
 * @date 2020/12/03
 */
@ApiModel(value = "菜单新增入参", description = "菜单管理界面新增入参")
@Data
public class SysPermissionAddInput {
    /**
     * 父ID
     */
    @ApiModelProperty(value = "父ID")
    private Long parentId;
    /**
     * 菜单标题
     */
    @ApiModelProperty(value = "菜单标题", required = true)
    @NotNull(message = "菜单标题不能为空")
    private String title;
    /**
     * 路径
     */
    @ApiModelProperty(value = "路径")
    private String url;
    /**
     * 菜单图标
     */
    @ApiModelProperty(value = "菜单图标")
    private String icon;
    /**
     * 菜单类型(0:一级菜单; 1:子菜单 2:按钮权限)
     */
    @ApiModelProperty(value = "菜单类型(0:一级菜单; 1:子菜单 2:按钮权限)", required = true)
    @NotNull(message = "菜单类型不能为空")
    private Long menuType;
    /**
     * 菜单编码
     */
    @ApiModelProperty(value = "菜单编码", required = true)
    @NotNull(message = "菜单编码不能为空")
    private String perms;
    /**
     * 权限策略1显示2禁用
     */
    @ApiModelProperty(value = "权限策略1显示2禁用")
    private String permsType;
    /**
     * 菜单排序
     */
    @ApiModelProperty(value = "菜单排序")
    private Long sortNo;
    /**
     * 是否叶子节点: 1:是   0:不是
     */
    @ApiModelProperty(value = "是否叶子节点: 1:是   0:不是", required = true)
    @NotNull(message = "是否叶子节点不能为空")
    private Long isLeaf;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String describe;
    /**
     * 菜单类别 0.数据展示平台 1.控制台 2.其它
     */
    @ApiModelProperty(value = "菜单类别 0.数据展示平台 1.控制台 2.其它", required = true)
    @NotNull(message = "菜单类别不能为空")
    private Long menuClass;
}
