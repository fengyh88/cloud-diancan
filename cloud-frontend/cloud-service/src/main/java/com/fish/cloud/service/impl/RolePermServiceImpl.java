package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.RolePerm;
import com.fish.cloud.repo.RolePermMapper;
import com.fish.cloud.service.IRolePermService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与权限对应关系
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class RolePermServiceImpl extends ServiceImpl<RolePermMapper, RolePerm> implements IRolePermService {
	
}
