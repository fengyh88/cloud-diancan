package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.SysConfig;
import com.fish.cloud.repo.SysConfigMapper;
import com.fish.cloud.service.ISysConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置信息
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {
	
}
