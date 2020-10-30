package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.model.EmpLoginRecord;
import com.fish.cloud.repo.EmpLoginRecordMapper;
import com.fish.cloud.service.IEmpLoginRecordService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工登录记录
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class EmpLoginRecordServiceImpl extends ServiceImpl<EmpLoginRecordMapper, EmpLoginRecord> implements IEmpLoginRecordService {
	
}
