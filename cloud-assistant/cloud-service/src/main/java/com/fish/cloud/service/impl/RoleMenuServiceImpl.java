package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.RoleMenu;
import com.fish.cloud.repo.RoleMenuMapper;
import com.fish.cloud.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
	
}
