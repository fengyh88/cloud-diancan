package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.SysConfig;
import com.fish.cloud.repo.SysConfigMapper;
import com.fish.cloud.service.ISysConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统配置信息
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {

    @Override
    public SysConfig getByKey(String shopId, String key) {
        var model = baseMapper.selectOne(new LambdaQueryWrapper<SysConfig>()
                .eq(SysConfig::getShopId, shopId)
                .eq(SysConfig::getParamKey, key)
                .ne(SysConfig::getStatus, -1));
        return model;
    }

    @Override
    public List<SysConfig> all(String shopId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<SysConfig>()
                .eq(SysConfig::getShopId, shopId)
                .ne(SysConfig::getStatus, -1));
        return models;
    }
}
