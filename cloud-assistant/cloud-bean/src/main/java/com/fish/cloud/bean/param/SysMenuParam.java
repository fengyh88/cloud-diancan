package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysMenuParam {

    @ApiModelProperty(value = "菜单层级(1一级菜单 2二级菜单 9按钮 0全部)")
    private Integer menuLevel;

    @ApiModelProperty(value = "角色Id")
    private Long roleId;
}
