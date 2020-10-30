package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.ScheduleJob;
import com.fish.cloud.repo.ScheduleJobMapper;
import com.fish.cloud.service.IScheduleJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class ScheduleJobServiceImpl extends ServiceImpl<ScheduleJobMapper, ScheduleJob> implements IScheduleJobService {
	
}
