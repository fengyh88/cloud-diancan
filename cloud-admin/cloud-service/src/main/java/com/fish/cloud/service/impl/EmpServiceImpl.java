package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.Emp;
import com.fish.cloud.repo.EmpMapper;
import com.fish.cloud.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {
	
}
