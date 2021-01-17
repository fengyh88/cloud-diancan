package com.fish.cloud.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.RoleMenu;
import com.fish.cloud.bean.model.RolePerm;
import com.fish.cloud.repo.RoleMenuMapper;
import com.fish.cloud.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色与菜单对应关系
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void bindRoleMenus(Long roleId, String menuIds) {
        // 先清掉历史
        baseMapper.delete(new LambdaQueryWrapper<RoleMenu>().eq(RoleMenu::getRoleId, roleId));
        // 循环新增
        for (String menuId : StrUtil.split(menuIds, ",")) {
            var model = new RoleMenu();
            model.setRoleId(roleId);
            model.setMenuId(Long.getLong(menuId));
            this.baseMapper.insert(model);
        }
    }
}
