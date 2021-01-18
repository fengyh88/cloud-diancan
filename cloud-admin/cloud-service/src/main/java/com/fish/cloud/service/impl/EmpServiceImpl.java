package com.fish.cloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.EmpDto;
import com.fish.cloud.bean.model.Emp;
import com.fish.cloud.bean.param.EmpAddParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.common.util.MD5Util;
import com.fish.cloud.repo.EmpMapper;
import com.fish.cloud.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 * 员工
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

    @Value("${prop.default.password}")
    private static String defaultPassword;


    @Override
    public List<Emp> all() {
        return baseMapper.selectList(new LambdaQueryWrapper<Emp>()
                .eq(Emp::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Emp::getStatus, 1));
    }

    /**
     * 更新状态，正常禁用删除
     * @param id
     * @param status
     * @return
     */
    @Override
    public TupleRet status(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("员工不存在");
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

    @Override
    public TupleRet add(EmpAddParam empAddParam) {
        var count = baseMapper.selectCount(new LambdaQueryWrapper<Emp>()
                .eq(Emp::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Emp::getEmpNumber, empAddParam.getEmpNumber()));
        if (count > 0) {
            return TupleRet.failed("工号不得重复");
        }
        var countMobile = baseMapper.selectCount(new LambdaQueryWrapper<Emp>()
                .eq(Emp::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Emp::getMobile, empAddParam.getMobile()));
        if (countMobile > 0) {
            return TupleRet.failed("手机号不得重复");
        }

        try {
            var model = new Emp();
            BeanUtil.copyProperties(empAddParam, model);
            model.setShopId(ApiContextHolder.getAuthDto().getShopId());
            // 默认密码
            model.setPassword(MD5Util.md5(defaultPassword));
            // 默认启用
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
    public TupleRet edit(EmpAddParam empAddParam) {
        var model = baseMapper.selectById(empAddParam.getEmpId());
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("员工不存在");
        }
        var count = baseMapper.selectCount(new LambdaQueryWrapper<Emp>()
                .eq(Emp::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Emp::getEmpNumber, empAddParam.getEmpNumber())
                .ne(Emp::getEmpId,empAddParam.getEmpId()));
        if (count > 0) {
            return TupleRet.failed("工号不得重复");
        }
        var countMobile = baseMapper.selectCount(new LambdaQueryWrapper<Emp>()
                .eq(Emp::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Emp::getMobile, empAddParam.getMobile())
                .ne(Emp::getEmpId,empAddParam.getEmpId()));
        if (countMobile > 0) {
            return TupleRet.failed("手机号不得重复");
        }

        try {
            BeanUtil.copyProperties(empAddParam, model);
            model.setUpdateTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

}
