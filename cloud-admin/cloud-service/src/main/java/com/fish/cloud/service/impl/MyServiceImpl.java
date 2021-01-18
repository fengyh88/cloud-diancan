package com.fish.cloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.Emp;
import com.fish.cloud.bean.param.EmpMyParam;
import com.fish.cloud.bean.param.EmpPwdParam;
import com.fish.cloud.bean.param.LoginParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.token.AuthDto;
import com.fish.cloud.common.token.JwtUtil;
import com.fish.cloud.common.util.MD5Util;
import com.fish.cloud.service.IEmpService;
import com.fish.cloud.service.ILoginService;
import com.fish.cloud.service.IMyService;
import com.fish.cloud.service.IShopService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 我的
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class MyServiceImpl implements IMyService {

    @Autowired
    private IEmpService empService;

    /**
     * 更新密码
     * @param empPwdParam
     * @return
     */
    @Override
    public TupleRet updatePassword(EmpPwdParam empPwdParam) {
        var model = empService.getById(ApiContextHolder.getAuthDto().getEmpId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("用户不存在");
        }
        if(!model.getPassword().equals(MD5Util.md5(empPwdParam.getOldPwd()))) {
            return TupleRet.failed("原密码错误");
        }
        if (!empPwdParam.getNewPwd().equals(empPwdParam.getNewPwd2())) {
            return TupleRet.failed("两次密码输入不一致");
        }
        model.setPassword(MD5Util.md5(empPwdParam.getNewPwd()));

        try {
            empService.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("更新密码失败");
        }

        return TupleRet.success();
    }

    /**
     * 更新手机号
     * @param mobile
     * @return
     */
    @Override
    public TupleRet updateMobile(String mobile) {
        var model = empService.getById(ApiContextHolder.getAuthDto().getEmpId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("用户不存在");
        }
        var modelMobile = empService.getOne(new LambdaQueryWrapper<Emp>()
                .eq(Emp::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .ne(Emp::getEmpId, ApiContextHolder.getAuthDto().getEmpId())
                .eq(Emp::getMobile, mobile));
        if (ObjectUtil.isNotNull(modelMobile)){
            return TupleRet.failed("该手机号已注册");
        }

        try {
            model.setMobile(mobile);
            empService.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("更新失败");
        }

        return TupleRet.success();
    }

    /**
     * 编辑个人资料
     * @param empMyParam
     * @return
     */
    @Override
    public TupleRet edit(EmpMyParam empMyParam) {
        var model = empService.getById(ApiContextHolder.getAuthDto().getEmpId());
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("用户不存在");
        }
        try {
            BeanUtil.copyProperties(empMyParam, model);

            empService.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }
}
