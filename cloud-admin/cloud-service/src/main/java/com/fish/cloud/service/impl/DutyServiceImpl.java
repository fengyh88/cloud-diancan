package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.fish.cloud.bean.model.Duty;
import com.fish.cloud.bean.param.DutyAddParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.DutyMapper;
import com.fish.cloud.service.IDutyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 岗位
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class DutyServiceImpl extends ServiceImpl<DutyMapper, Duty> implements IDutyService {

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
            return TupleRet.failed("岗位不存在");
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

    @Override
    public TupleRet add(String shopId, DutyAddParam dutyAddParam) {
        var count = baseMapper.selectCount(new LambdaQueryWrapper<Duty>()
                .eq(Duty::getShopId, shopId)
                .eq(Duty::getDutyName, dutyAddParam.getDutyName())
                .ne(Duty::getStatus,-1));
        if (count > 0) {
            return TupleRet.failed("名称不得重复");
        }

        try {
            var model = new Duty();
            model.setDutyName(dutyAddParam.getDutyName());
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
    public TupleRet edit(String shopId, DutyAddParam dutyAddParam) {
        var model = baseMapper.selectById(dutyAddParam.getDutyId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("岗位不存在");
        }
        var count = baseMapper.selectCount(new LambdaQueryWrapper<Duty>()
                .eq(Duty::getShopId, shopId)
                .eq(Duty::getDutyName, dutyAddParam.getDutyName())
                .ne(Duty::getStatus, -1));
        if (count > 0) {
            return TupleRet.failed("名称不得重复");
        }

        try {
            model.setDutyName(dutyAddParam.getDutyName());
            model.setUpdateTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

    @Override
    public Duty detail(Long id) {
        var model = baseMapper.selectById(id);
        return model;
    }

    @Override
    public List<Duty> all(String shopId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<Duty>()
                .eq(Duty::getShopId, shopId)
                .ne(Duty::getStatus, -1));
        return models;
    }
}
