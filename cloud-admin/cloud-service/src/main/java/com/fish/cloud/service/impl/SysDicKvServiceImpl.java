package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.fish.cloud.bean.model.SysDicKv;
import com.fish.cloud.bean.param.SysDicKvAddParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.SysDicKvMapper;
import com.fish.cloud.service.ISysDicKvService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * @since 2020-03-07
 */
@Slf4j
@Service
public class SysDicKvServiceImpl extends ServiceImpl<SysDicKvMapper, SysDicKv> implements ISysDicKvService {

    /**
     * 更新状态，正常禁用删除
     * @param id
     * @param status
     * @return
     */
    @Override
    public TupleRet updateStatus(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("key不存在");
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

    @Override
    public TupleRet add(String shopId, SysDicKvAddParam sysDicKvAddParam) {
        var count = baseMapper.selectCount(new LambdaQueryWrapper<SysDicKv>()
                .eq(SysDicKv::getShopId, shopId)
                .eq(SysDicKv::getDicCode, sysDicKvAddParam.getDicCode())
                .eq(SysDicKv::getKey, sysDicKvAddParam.getKey())
                .ne(SysDicKv::getStatus,-1));
        if (count > 0) {
            return TupleRet.failed("key不得重复");
        }

        try {
            var model = new SysDicKv();
            model.setDicCode(sysDicKvAddParam.getDicCode());
            model.setKey(sysDicKvAddParam.getKey());
            model.setValue(sysDicKvAddParam.getValue());
            model.setRemark(sysDicKvAddParam.getRemark());
            model.setShopId(shopId);
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
    public TupleRet edit(String shopId, SysDicKvAddParam sysDicKvAddParam) {
        var model = baseMapper.selectById(sysDicKvAddParam.getId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("key不存在");
        }
        var count = baseMapper.selectCount(new LambdaQueryWrapper<SysDicKv>()
                .eq(SysDicKv::getShopId, shopId)
                .eq(SysDicKv::getDicCode, sysDicKvAddParam.getDicCode())
                .eq(SysDicKv::getKey, sysDicKvAddParam.getKey())
                .ne(SysDicKv::getStatus,-1));
        if (count > 0) {
            return TupleRet.failed("key不得重复");
        }

        try {
            model.setKey(sysDicKvAddParam.getKey());
            model.setValue(sysDicKvAddParam.getValue());
            model.setRemark(sysDicKvAddParam.getRemark());
            model.setUpdateTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

    @Override
    public List<SysDicKv> listByDicCode(String shopId, String dicCode) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<SysDicKv>()
                .eq(SysDicKv::getShopId, shopId)
                .eq(SysDicKv::getDicCode, dicCode)
                .ne(SysDicKv::getStatus, -1));
        return models;
    }
}
