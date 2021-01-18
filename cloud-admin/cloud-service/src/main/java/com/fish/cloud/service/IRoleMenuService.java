package com.fish.cloud.service;

import com.fish.cloud.bean.model.RoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色与菜单对应关系
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface IRoleMenuService extends IService<RoleMenu> {
    /**
     * 根据角色Id列表获取菜单Id列表
     *
     * @param roleId
     * @return
     */
    List<Long> listMenuIdByRoleId(Long roleId);
    /**
     * 为角色绑定菜单列表
     * @param roleId
     * @param menuIds
     */
    void bindRoleMenus(Long roleId, String menuIds);
}
