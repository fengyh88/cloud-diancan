package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.ScheduleJobLog;
import com.fish.cloud.repo.ScheduleJobLogMapper;
import com.fish.cloud.service.IScheduleJobLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务日志
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class ScheduleJobLogServiceImpl extends ServiceImpl<ScheduleJobLogMapper, ScheduleJobLog> implements IScheduleJobLogService {
	
}
