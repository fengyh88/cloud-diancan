package com.fish.cloud.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(value = "菜单Dto", description = "菜单Dto")
@Data
public class SysMenuDto {

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long menuId;

    /**
     * 父ID
     */
    @ApiModelProperty(value = "父ID")
    private Long pId;

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
     * 菜单图标
     */
    @ApiModelProperty(value = "菜单图标")
    private String icon;

    /**
     * 菜单类型(1一级菜单 2二级菜单 9按钮)
     */
    @ApiModelProperty(value = "菜单类型(1一级菜单 2二级菜单 9按钮)")
    private Long menuType;

    /**
     * 权限策略1显示0禁用
     */
    @ApiModelProperty(value = "权限策略1显示0禁用")
    private Integer showType;

    /**
     * 菜单排序
     */
    @ApiModelProperty(value = "菜单排序")
    private Integer seq;

    /**
     * 是否叶子节点: 1:是   0:不是
     */
    @ApiModelProperty(value = "是否叶子节点: 1:是   0:不是")
    private Long isLeaf;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String des;

    /**
     * 菜单种类 0.数据展示平台 1.控制台
     */
    @ApiModelProperty(value = "菜单种类 0.数据展示平台 1.控制台")
    private Long menuClass;

    /**
     * 子菜单
     */
    @ApiModelProperty(value = "子菜单")
    private List<SysMenuDto> subs;
}
