package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.fish.cloud.bean.model.SysConfig;
import com.fish.cloud.bean.param.SysConfigAddParam;
import com.fish.cloud.bean.param.SysConfigEditParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
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
                .eq(SysConfig::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(SysConfig::getParamKey, key)
                .eq(SysConfig::getStatus, 1));
        return model;
    }

    @Override
    public TupleRet add(SysConfigAddParam sysConfigAddParam) {
        var count = baseMapper.selectCount(new LambdaQueryWrapper<SysConfig>()
                .eq(SysConfig::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(SysConfig::getParamKey, sysConfigAddParam.getParamKey())
                .ne(SysConfig::getStatus, -1));
        if (count > 0) {
            return TupleRet.failed("key不得重复");
        }

        try {
            var model = new SysConfig();
            model.setParamKey(sysConfigAddParam.getParamKey());
            model.setParamValue(sysConfigAddParam.getParamValue());
            model.setRemark(sysConfigAddParam.getRemark());
            model.setShopId(ApiContextHolder.getAuthDto().getShopId());
            model.setStatus(1);
            model.setCreateTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.insert(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

    @Override
    public TupleRet edit(SysConfigEditParam sysConfigEditParam) {
        var model = baseMapper.selectById(sysConfigEditParam.getId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("配置信息不存在");
        }

        try {
            model.setParamValue(sysConfigEditParam.getParamValue());
            model.setRemark(sysConfigEditParam.getRemark());
            model.setUpdateTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

}
