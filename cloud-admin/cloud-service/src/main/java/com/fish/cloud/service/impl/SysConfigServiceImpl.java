package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.fish.cloud.bean.model.SysConfig;
import com.fish.cloud.bean.param.SysConfigEditParam;
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
 * @since 2020-03-07
 */
@Slf4j
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {

    @Override
    public TupleRet edit(String shopId, SysConfigEditParam sysConfigEditParam) {
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
