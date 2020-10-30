package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.EmpDto;
import com.fish.cloud.bean.model.Emp;
import com.fish.cloud.bean.param.LoginParam;
import com.fish.cloud.bean.param.EmpAddParam;
import com.fish.cloud.bean.param.EmpPwdParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.common.util.MD5Util;
import com.fish.cloud.common.util.SecurityUtil;
import com.fish.cloud.repo.EmpMapper;
import com.fish.cloud.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.service.IShopService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 * 员工
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

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
            return TupleRet.failed("员工不存在");
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

    @Override
    public TupleRet add(String shopId, EmpAddParam empAddParam) {
        var count = baseMapper.selectCount(new LambdaQueryWrapper<Emp>()
                .eq(Emp::getShopId, shopId)
                .eq(Emp::getEmpNumber, empAddParam.getEmpNumber()));
        if (count > 0) {
            return TupleRet.failed("工号不得重复");
        }
        var countMobile = baseMapper.selectCount(new LambdaQueryWrapper<Emp>()
                .eq(Emp::getShopId, shopId)
                .eq(Emp::getMobile, empAddParam.getMobile()));
        if (countMobile > 0) {
            return TupleRet.failed("手机号不得重复");
        }

        try {
            var model = new Emp();
            model.setEmpNumber(empAddParam.getEmpNumber());
            model.setEmpName(empAddParam.getEmpName());
            // 默认密码
            model.setPassword(MD5Util.md5("111111"));
            model.setEmail(empAddParam.getEmail());
            model.setMobile(empAddParam.getMobile());
            model.setGender(empAddParam.getGender());
            model.setBirthDate(empAddParam.getBirthDate());
            model.setPic(empAddParam.getPic());
            model.setShopId(shopId);
            model.setDeptId(empAddParam.getDeptId());
            model.setDutyId(empAddParam.getDutyId());
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
    public TupleRet edit(String shopId, EmpAddParam empAddParam) {
        var model = baseMapper.selectById(empAddParam.getEmpId());
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("员工不存在");
        }
        var count = baseMapper.selectCount(new LambdaQueryWrapper<Emp>()
                .eq(Emp::getShopId, shopId)
                .eq(Emp::getEmpNumber, empAddParam.getEmpNumber())
                .ne(Emp::getEmpId,empAddParam.getEmpId()));
        if (count > 0) {
            return TupleRet.failed("工号不得重复");
        }
        var countMobile = baseMapper.selectCount(new LambdaQueryWrapper<Emp>()
                .eq(Emp::getShopId, shopId)
                .eq(Emp::getMobile, empAddParam.getMobile())
                .ne(Emp::getEmpId,empAddParam.getEmpId()));
        if (countMobile > 0) {
            return TupleRet.failed("手机号不得重复");
        }

        try {
            model.setEmpNumber(empAddParam.getEmpNumber());
            model.setEmpName(empAddParam.getEmpName());
            model.setEmail(empAddParam.getEmail());
            model.setMobile(empAddParam.getMobile());
            model.setGender(empAddParam.getGender());
            model.setBirthDate(empAddParam.getBirthDate());
            model.setPic(empAddParam.getPic());
            model.setShopId(shopId);
            model.setDeptId(empAddParam.getDeptId());
            model.setDutyId(empAddParam.getDutyId());
            model.setUpdateTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

    @Override
    public EmpDto detail(Long id) {
        return baseMapper.detail(id);
    }

    @Override
    public List<EmpDto> all(String shopId) {
        return baseMapper.all(shopId);
    }

}
