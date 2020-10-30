package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.fish.cloud.bean.model.Dept;
import com.fish.cloud.bean.param.DeptAddParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.DeptMapper;
import com.fish.cloud.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 部门
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

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
            return TupleRet.failed("部门不存在");
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

    @Override
    public TupleRet add(String shopId, DeptAddParam deptAddParam) {
        var count = baseMapper.selectCount(new LambdaQueryWrapper<Dept>()
                .eq(Dept::getShopId, shopId)
                .eq(Dept::getDeptName, deptAddParam.getDeptName())
                .ne(Dept::getStatus,-1));
        if (count > 0) {
            return TupleRet.failed("名称不得重复");
        }

        try {
            var model = new Dept();
            model.setDeptName(deptAddParam.getDeptName());
            model.setShopId(shopId);
            model.setPId(deptAddParam.getPId());
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
    public TupleRet edit(String shopId, DeptAddParam deptAddParam) {
        var model = baseMapper.selectById(deptAddParam.getDeptId());
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("部门不存在");
        }
        var count = baseMapper.selectCount(new LambdaQueryWrapper<Dept>()
                .eq(Dept::getShopId, shopId)
                .eq(Dept::getDeptName, deptAddParam.getDeptName())
                .ne(Dept::getStatus,-1));
        if (count > 0) {
            return TupleRet.failed("名称不得重复");
        }

        try {
            model.setDeptName(deptAddParam.getDeptName());
            model.setPId(deptAddParam.getPId());
            model.setUpdateTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

    @Override
    public List<Dept> all(String shopId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<Dept>()
                .eq(Dept::getShopId, shopId)
                .ne(Dept::getStatus, -1));
        return models;
    }
}
