package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 系统菜单
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Data
@TableName("cloud_sys_menu")
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

	@TableId(value="menu_id", type= IdType.AUTO)
	private Long menuId;
    /**
     * 父菜单ID，一级菜单为0
     */
	@TableField("p_id")
	private Long pId;
    /**
     * 菜单类型(0:一级菜单; 1:子菜单 2:按钮权限)
     */
	@TableField("menu_type")
	private Integer menuType;
	/**
	 * 菜单标题
	 */
	@TableField("title")
	private String title;
	/**
	 * 路径
	 */
	@TableField("url")
	private String url;
	/**
	 * 菜单图标
	 */
	@TableField("icon")
	private String icon;
    /**
     * 排序
     */
	private Integer seq;
    /**
     * 店铺Id
     */
	@TableField("shop_id")
	private Long shopId;
	/**
	 * 是否叶子节点: 1:是   0:不是
	 */
	@TableField("is_leaf")
	private Integer isLeaf;
	/**
	 * 描述
	 */
	@TableField("des")
	private String des;

	/**
	 * 权限策略1显示0禁用
	 */
	@TableField("show_type")
	private Integer showType;
	/**
	 * 菜单类别 0.平台 1.控制台
	 */
	@TableField("menu_class")
	private Integer menuClass;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;

	@Override
	protected Serializable pkVal() {
		return this.menuId;
	}

}
