package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.Emp;
import com.fish.cloud.bean.param.EmpMyParam;
import com.fish.cloud.bean.param.LoginParam;
import com.fish.cloud.bean.param.EmpPwdParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.token.AuthDto;
import com.fish.cloud.common.token.JwtUtil;
import com.fish.cloud.common.util.MD5Util;
import com.fish.cloud.service.IEmpService;
import com.fish.cloud.service.ILoginService;
import com.fish.cloud.service.IShopService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 登录
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private IShopService shopService;
    @Autowired
    private IEmpService empService;

    /**
     * 登录
     * @param loginParam
     * @return
     */
    @Override
    public TupleRet<String> token(LoginParam loginParam) {
        // 判断店铺是否存在
        var shop = shopService.getById(loginParam.getShopId());
        if (ObjectUtils.isEmpty(shop)) {
            return TupleRet.failed("店铺不存在");
        }

        // 判断员工是否存在
        LambdaQueryWrapper<Emp> queryWrapper = new LambdaQueryWrapper<Emp>()
                .eq(Emp::getShopId, loginParam.getShopId())
                .eq(Emp::getStatus, 1)
                .and(wrapper -> {
                    wrapper.eq(Emp::getEmpNumber, loginParam.getUserNumber())
                            .or()
                            .eq(Emp::getMobile, loginParam.getUserNumber());
                    return wrapper;
                });
        var emp = empService.getOne(queryWrapper);
        if (ObjectUtils.isEmpty(emp)) {
            return TupleRet.failed("用户不存在");
        }

        if (!MD5Util.authenticatePassword(emp.getPassword(),loginParam.getPassword())) {
            return TupleRet.failed("密码不正确");
        }

        // 生成token并返回
        AuthDto authDto = new AuthDto(emp.getEmpId().toString(), shop.getShopId());
        String token = JwtUtil.toToken(authDto);
        return TupleRet.success(token);
    }

    /**
     * 更新密码
     * @param empId
     * @param empPwdParam
     * @return
     */
    @Override
    public TupleRet updatePassword(String empId,EmpPwdParam empPwdParam) {
        var model = empService.getById(empId);
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("用户不存在");
        }
        if(!model.getPassword().equals(empPwdParam.getOldPwd())) {
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
     * 更新头像地址
     * @param empId
     * @param avatarUrl
     * @return
     */
    @Override
    public TupleRet updateAvatarUrl(String empId, String avatarUrl) {
        var model = empService.getById(empId);
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("用户不存在");
        }

        try {
            model.setPic(avatarUrl);
            empService.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("更新失败");
        }

        return TupleRet.success();
    }

    /**
     * 某员工的手机号在某店铺是否已存在
     * @param empId
     * @param shopId
     * @param mobile
     * @return
     */
    @Override
    public Boolean existMobile(String empId, String shopId, String mobile) {
        Emp emp = empService.getOne(new LambdaQueryWrapper<Emp>()
                .eq(Emp::getShopId, shopId)
                .ne(Emp::getEmpId, empId)
                .eq(Emp::getMobile, mobile));
        if (ObjectUtils.isEmpty(emp)){
            // 不存在
            return false;
        }
        // 已存在
        return true;
    }

    /**
     * 更新手机号
     * @param empId
     * @param mobile
     * @return
     */
    @Override
    public TupleRet updateMobile(String empId, String mobile) {
        var model = empService.getById(empId);
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("用户不存在");
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
     * 修改个人资料
     * @param empId
     * @param empMyParam
     * @return
     */
    @Override
    public TupleRet editMy(String empId, EmpMyParam empMyParam) {
        var model = empService.getById(empId);
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("用户不存在");
        }
        try {
            model.setEmpName(empMyParam.getEmpName());
            model.setEmail(empMyParam.getEmail());
            model.setGender(empMyParam.getGender());
            model.setBirthDate(empMyParam.getBirthDate());

            empService.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

}
