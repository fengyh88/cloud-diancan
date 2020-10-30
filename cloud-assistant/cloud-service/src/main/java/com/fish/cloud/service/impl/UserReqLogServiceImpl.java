package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.UserReqLog;
import com.fish.cloud.repo.UserReqLogMapper;
import com.fish.cloud.service.IUserReqLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户请求日志
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class UserReqLogServiceImpl extends ServiceImpl<UserReqLogMapper, UserReqLog> implements IUserReqLogService {
	
}
