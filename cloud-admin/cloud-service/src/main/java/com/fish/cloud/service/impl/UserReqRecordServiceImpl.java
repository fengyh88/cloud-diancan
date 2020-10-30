package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.UserReqRecord;
import com.fish.cloud.repo.UserReqRecordMapper;
import com.fish.cloud.service.IUserReqRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户请求记录
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class UserReqRecordServiceImpl extends ServiceImpl<UserReqRecordMapper, UserReqRecord> implements IUserReqRecordService {
	
}
