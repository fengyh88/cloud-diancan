package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.model.EmpLoginLog;
import com.fish.cloud.repo.EmpLoginLogMapper;
import com.fish.cloud.service.IEmpLoginLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工登录日志
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class EmpLoginLogServiceImpl extends ServiceImpl<EmpLoginLogMapper, EmpLoginLog> implements IEmpLoginLogService {
	
}
