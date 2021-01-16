package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.model.SysDicKv;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.repo.SysDicKvMapper;
import com.fish.cloud.service.ISysDicKvService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统字典kv
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class SysDicKvServiceImpl extends ServiceImpl<SysDicKvMapper, SysDicKv> implements ISysDicKvService {

    @Override
    public List<SysDicKv> listByDicCode(String dicCode) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<SysDicKv>()
                .eq(SysDicKv::getShopId, ApiContextHolder.getShopId())
                .eq(SysDicKv::getDicCode, dicCode)
                .eq(SysDicKv::getStatus, 1));
        return models;
    }
}
