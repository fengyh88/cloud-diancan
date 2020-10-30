package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.EmpReqLog;
import com.fish.cloud.repo.EmpReqLogMapper;
import com.fish.cloud.service.IEmpReqLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台请求日志
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class EmpReqLogServiceImpl extends ServiceImpl<EmpReqLogMapper, EmpReqLog> implements IEmpReqLogService {
	
}
