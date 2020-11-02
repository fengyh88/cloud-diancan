package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.model.Perm;
import com.fish.cloud.repo.PermMapper;
import com.fish.cloud.service.IPermService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class PermServiceImpl extends ServiceImpl<PermMapper, Perm> implements IPermService {
	
}
