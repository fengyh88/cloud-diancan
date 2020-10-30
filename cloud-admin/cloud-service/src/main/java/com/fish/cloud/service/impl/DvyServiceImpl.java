package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.fish.cloud.bean.model.Dvy;
import com.fish.cloud.bean.model.Role;
import com.fish.cloud.bean.param.DvyAddParam;
import com.fish.cloud.bean.param.RoleAddParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.DvyMapper;
import com.fish.cloud.service.IDvyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 送货方式
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class DvyServiceImpl extends ServiceImpl<DvyMapper, Dvy> implements IDvyService {

    /**
     * 更新状态，正常禁用删除
     * @param id
     * @param status
     * @return
     */
    @Transactional
    @Override
    public TupleRet updateStatus(String shopId,Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("送货方式不存在");
        }

        // 如果是启用，其他自动禁用
        if (status == 1){
            // 查找店铺中启用的
            var modelsQy = baseMapper.selectList(new LambdaQueryWrapper<Dvy>()
            .eq(Dvy::getShopId, shopId)
            .eq(Dvy::getStatus, 1));

            // 循环处理
            modelsQy.forEach(modelQy -> {
                // 设置为禁用
                modelQy.setStatus(0);
                // 保存
                baseMapper.updateById(modelQy);
            });
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

    @Override
    public TupleRet add(String shopId, DvyAddParam dvyAddParam) {
        var count = baseMapper.selectCount(new LambdaQueryWrapper<Dvy>()
                .eq(Dvy::getShopId, shopId)
                .eq(Dvy::getDvyCode, dvyAddParam.getDvyCode())
                .ne(Dvy::getStatus, -1));
        if (count > 0) {
            return TupleRet.failed("编码不得重复");
        }

        try {
            var model = new Dvy();
            model.setDvyCode(dvyAddParam.getDvyCode());
            model.setDvyName(dvyAddParam.getDvyName());
            model.setDvyAmount(dvyAddParam.getDvyAmount());
            model.setShopId(shopId);
            model.setFreeId(dvyAddParam.getFreeId());
            model.setStatus(0); // 新建后，默认禁用
            model.setCreateTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.insert(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

    @Override
    public TupleRet edit(String shopId, DvyAddParam dvyAddParam) {
        var model = baseMapper.selectById(dvyAddParam.getDvyId());
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("送货方式不存在");
        }
        var count = baseMapper.selectCount(new LambdaQueryWrapper<Dvy>()
                .eq(Dvy::getShopId, shopId)
                .eq(Dvy::getDvyCode, dvyAddParam.getDvyCode())
                .ne(Dvy::getStatus, -1));
        if (count > 0) {
            return TupleRet.failed("编码不得重复");
        }

        try {
            model.setDvyCode(dvyAddParam.getDvyCode());
            model.setDvyName(dvyAddParam.getDvyName());
            model.setDvyAmount(dvyAddParam.getDvyAmount());
            model.setFreeId(dvyAddParam.getFreeId());
            model.setUpdateTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

    @Override
    public List<Dvy> all(String shopId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<Dvy>()
                .eq(Dvy::getShopId, shopId)
                .ne(Dvy::getStatus, -1));
        return models;
    }
}
