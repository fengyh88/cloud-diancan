package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.UserLoginRecord;
import com.fish.cloud.repo.UserLoginRecordMapper;
import com.fish.cloud.service.IUserLoginRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录记录
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class UserLoginRecordServiceImpl extends ServiceImpl<UserLoginRecordMapper, UserLoginRecord> implements IUserLoginRecordService {
	
}
