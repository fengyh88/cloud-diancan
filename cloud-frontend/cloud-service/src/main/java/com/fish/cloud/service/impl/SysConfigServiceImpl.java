package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.SysConfig;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.repo.SysConfigMapper;
import com.fish.cloud.service.ISysConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统配置信息
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {

    @Override
    public SysConfig getByKey(String key) {
        var model = baseMapper.selectOne(new LambdaQueryWrapper<SysConfig>()
                .eq(SysConfig::getShopId, ApiContextHolder.getShopId())
                .eq(SysConfig::getParamKey, key)
                .ne(SysConfig::getStatus, -1));
        return model;
    }

    @Override
    public List<SysConfig> all() {
        var models = baseMapper.selectList(new LambdaQueryWrapper<SysConfig>()
                .eq(SysConfig::getShopId, ApiContextHolder.getShopId())
                .ne(SysConfig::getStatus, -1));
        return models;
    }
}
