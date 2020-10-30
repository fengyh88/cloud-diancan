package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.fish.cloud.bean.model.Role;
import com.fish.cloud.bean.model.SysDic;
import com.fish.cloud.bean.param.SysDicAddParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.SysDicMapper;
import com.fish.cloud.service.ISysDicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * @since 2020-03-07
 */
@Slf4j
@Service
public class SysDicServiceImpl extends ServiceImpl<SysDicMapper, SysDic> implements ISysDicService {

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
            return TupleRet.failed("系统字典不存在");
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

    @Override
    public TupleRet add(String shopId, SysDicAddParam sysDicAddParam) {
        var count = baseMapper.selectCount(new LambdaQueryWrapper<SysDic>()
                .eq(SysDic::getShopId, shopId)
                .eq(SysDic::getDicCode, sysDicAddParam.getDicCode())
                .ne(SysDic::getStatus,-1));
        if (count > 0) {
            return TupleRet.failed("编码不得重复");
        }

        try {
            var model = new SysDic();
            model.setDicCode(sysDicAddParam.getDicCode());
            model.setDicName(sysDicAddParam.getDicName());
            model.setRemark(sysDicAddParam.getRemark());
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
    public TupleRet edit(String shopId, SysDicAddParam sysDicAddParam) {
        var model = baseMapper.selectById(sysDicAddParam.getId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("系统字典不存在");
        }
        var count = baseMapper.selectCount(new LambdaQueryWrapper<SysDic>()
                .eq(SysDic::getShopId, shopId)
                .eq(SysDic::getDicCode, sysDicAddParam.getDicCode())
                .ne(SysDic::getStatus, -1));
        if (count > 0) {
            return TupleRet.failed("编码不得重复");
        }

        try {
            model.setDicCode(sysDicAddParam.getDicCode());
            model.setDicName(sysDicAddParam.getDicName());
            model.setRemark(sysDicAddParam.getRemark());
            model.setUpdateTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

    @Override
    public List<SysDic> all(String shopId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<SysDic>()
                .eq(SysDic::getShopId, shopId)
                .ne(SysDic::getStatus, -1));
        return models;
    }
}
