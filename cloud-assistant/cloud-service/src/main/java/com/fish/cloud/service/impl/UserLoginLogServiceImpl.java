package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.UserLoginLog;
import com.fish.cloud.repo.UserLoginLogMapper;
import com.fish.cloud.service.IUserLoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录日志
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class UserLoginLogServiceImpl extends ServiceImpl<UserLoginLogMapper, UserLoginLog> implements IUserLoginLogService {
	
}
