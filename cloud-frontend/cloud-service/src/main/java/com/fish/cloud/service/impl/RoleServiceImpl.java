package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.Role;
import com.fish.cloud.repo.RoleMapper;
import com.fish.cloud.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
	
}
