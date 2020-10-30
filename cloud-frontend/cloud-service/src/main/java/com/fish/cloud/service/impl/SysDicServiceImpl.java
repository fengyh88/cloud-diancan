package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.SysDic;
import com.fish.cloud.repo.SysDicMapper;
import com.fish.cloud.service.ISysDicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统字典
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class SysDicServiceImpl extends ServiceImpl<SysDicMapper, SysDic> implements ISysDicService {
    @Override
    public List<SysDic> all(String shopId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<SysDic>()
                .eq(SysDic::getShopId, shopId)
                .ne(SysDic::getStatus, -1));
        return models;
    }
}
