package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
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
	 * 店铺Id
	 */
	@TableField("shop_id")
	private Long shopId;
	/**
	 * 菜单类别 0 平台 1控制台
	 */
	@TableField("menu_cate")
	private Integer menuCate;
    /**
     * 菜单层级(1一级菜单 2二级菜单 9按钮)
     */
	@TableField("menu_level")
	private Integer menuLevel;
	/**
	 * 父菜单ID，一级菜单为1
	 */
	@TableField("p_id")
	private Long pId;
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
	 * 描述
	 */
	@TableField("des")
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
	 * 创建者
	 */
	@TableField("created_by")
	private Long createdBy;
    /**
     * 创建时间
     */
	@TableField("created_time")
	private Date createdTime;
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
