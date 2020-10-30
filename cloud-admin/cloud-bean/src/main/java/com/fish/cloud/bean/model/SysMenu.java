package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 菜单管理
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
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
     * 类型   0：目录   1：菜单   2：按钮
     */
	@TableField("menu_type")
	private Integer menuType;
    /**
     * 菜单名称
     */
	@TableField("menu_name")
	private String menuName;
    /**
     * 菜单URL
     */
	private String url;
    /**
     * 菜单图标
     */
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
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;


	public Long getMenuId() {
		return menuId;
	}

	public SysMenu setMenuId(Long menuId) {
		this.menuId = menuId;
		return this;
	}

	public Long getPId() {
		return pId;
	}

	public SysMenu setPId(Long pId) {
		this.pId = pId;
		return this;
	}

	public Integer getMenuType() {
		return menuType;
	}

	public SysMenu setMenuType(Integer menuType) {
		this.menuType = menuType;
		return this;
	}

	public String getMenuName() {
		return menuName;
	}

	public SysMenu setMenuName(String menuName) {
		this.menuName = menuName;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public SysMenu setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getIcon() {
		return icon;
	}

	public SysMenu setIcon(String icon) {
		this.icon = icon;
		return this;
	}

	public Integer getSeq() {
		return seq;
	}

	public SysMenu setSeq(Integer seq) {
		this.seq = seq;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public SysMenu setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public SysMenu setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public SysMenu setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.menuId;
	}

}
