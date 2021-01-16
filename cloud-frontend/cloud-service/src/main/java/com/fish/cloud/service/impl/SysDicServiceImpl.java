package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.model.SysDic;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.repo.SysDicMapper;
import com.fish.cloud.service.ISysDicService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统字典
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class SysDicServiceImpl extends ServiceImpl<SysDicMapper, SysDic> implements ISysDicService {

    @Override
    public List<SysDic> all() {
        var models = baseMapper.selectList(new LambdaQueryWrapper<SysDic>()
                .eq(SysDic::getShopId, ApiContextHolder.getShopId())
                .eq(SysDic::getStatus, 1));
        return models;
    }
}
