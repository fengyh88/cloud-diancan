package com.fish.cloud.service;

import com.fish.cloud.bean.model.RoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * 为角色绑定权限列表
     * @param roleId
     * @param menuIds
     */
    void bindRoleMenus(Long roleId, String menuIds);
}
