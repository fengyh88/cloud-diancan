package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.UserTp;
import com.fish.cloud.repo.UserTpMapper;
import com.fish.cloud.service.IUserTpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户第三方信息
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class UserTpServiceImpl extends ServiceImpl<UserTpMapper, UserTp> implements IUserTpService {
	
}
