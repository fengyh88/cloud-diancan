package com.fish.cloud.bean.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(value = "菜单Dto", description = "菜单Dto")
@Data
public class SysMenuDto {

    private Long menuId;

    /**
     * 菜单类别 0 平台 1控制台
     */
    private Integer menuCate;
    /**
     * 菜单层级(1一级菜单 2二级菜单 9按钮)
     */
    private Integer menuLevel;
    /**
     * 父菜单ID，一级菜单为1
     */
    private Long pId;
    /**
     * 菜单标题
     */
    private String title;
    /**
     * 路径
     */
    private String url;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 描述
     */
    private String des;
    /**
     * 默认是1正常 0禁用 -1删除
     */
    private Integer status;
    /**
     * 排序
     */
    private Integer seq;

    /**
     * 子菜单
     */
    @ApiModelProperty(value = "子菜单")
    private List<SysMenuDto> children;

    /**
     * 是否选中 1选中 0未选中
     */
    @ApiModelProperty(value = "是否选中 1选中 0未选中")
    private Integer isCheck;
}
