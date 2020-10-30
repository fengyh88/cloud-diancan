package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.SysDicKv;
import com.fish.cloud.repo.SysDicKvMapper;
import com.fish.cloud.service.ISysDicKvService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统字典kv
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class SysDicKvServiceImpl extends ServiceImpl<SysDicKvMapper, SysDicKv> implements ISysDicKvService {
    @Override
    public List<SysDicKv> listByDicCode(String shopId, String dicCode) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<SysDicKv>()
                .eq(SysDicKv::getShopId, shopId)
                .eq(SysDicKv::getDicCode, dicCode)
                .ne(SysDicKv::getStatus, -1));
        return models;
    }
}
