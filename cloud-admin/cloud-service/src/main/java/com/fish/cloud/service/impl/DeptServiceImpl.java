package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.fish.cloud.bean.model.Dept;
import com.fish.cloud.bean.param.DeptAddParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.DeptMapper;
import com.fish.cloud.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 部门
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    /**
     * 更新状态，正常禁用删除
     *
     * @param id
     * @param status
     * @return
     */
    @Override
    public TupleRet status(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("部门不存在");
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

    @Override
    public TupleRet add(DeptAddParam deptAddParam) {
        try {
            var model = new Dept();
            model.setDeptName(deptAddParam.getDeptName());
            model.setShopId(ApiContextHolder.getAuthDto().getShopId());
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
    public TupleRet edit(DeptAddParam deptAddParam) {
        var modelDb = baseMapper.selectById(deptAddParam.getDeptId());
        if (ObjectUtils.isEmpty(modelDb)) {
            return TupleRet.failed("部门不存在");
        }

        try {
            modelDb.setDeptName(deptAddParam.getDeptName());
            modelDb.setPId(deptAddParam.getPId());
            modelDb.setUpdateTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.updateById(modelDb);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }
}
