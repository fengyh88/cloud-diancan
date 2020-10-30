package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.SmsLog;
import com.fish.cloud.repo.SmsLogMapper;
import com.fish.cloud.service.ISmsLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 短信记录
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class SmsLogServiceImpl extends ServiceImpl<SmsLogMapper, SmsLog> implements ISmsLogService {
	
}
