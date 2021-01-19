package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SysMenuEditParam {

    @ApiModelProperty(value = "Id", required = true)
    @NotNull(message = "Id不能为空")
    private Long menuId;

    @ApiModelProperty(value = "父Id")
    private Long pId;

    @ApiModelProperty(value = "菜单类别 1 主系统 2控制台", required = true)
    @NotNull(message = "菜单类别不能为空")
    private Integer menuCate;

    @ApiModelProperty(value = "菜单层级(1一级菜单 2二级菜单 9按钮)", required = true)
    @NotNull(message = "菜单层级不能为空")
    private Long menuLevel;

    @ApiModelProperty(value = "标题", required = true)
    @NotNull(message = "标题不能为空")
    private String title;

    @ApiModelProperty(value = "路径")
    private String url;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "描述")
    private String des;

    @ApiModelProperty(value = "排序")
    private Integer seq;
}
