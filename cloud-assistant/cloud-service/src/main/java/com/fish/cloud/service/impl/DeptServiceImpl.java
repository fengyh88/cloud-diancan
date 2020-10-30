package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.Dept;
import com.fish.cloud.repo.DeptMapper;
import com.fish.cloud.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {
	
}
