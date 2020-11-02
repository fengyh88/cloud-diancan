package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.User;
import com.fish.cloud.bean.param.UserMyParam;
import com.fish.cloud.bean.param.UserPwdParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.MD5Util;
import com.fish.cloud.service.IMyService;
import com.fish.cloud.service.IUserService;
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
    private IUserService userService;

    /**
     * 更新密码
     * @param userPwdParam
     * @return
     */
    @Override
    public TupleRet updatePassword(UserPwdParam userPwdParam) {
        var model = userService.getById(ApiContextHolder.getAuthDto().getUserId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("用户不存在");
        }
        if(!model.getPassword().equals(MD5Util.md5(userPwdParam.getOldPwd()))) {
            return TupleRet.failed("原密码错误");
        }
        if (!userPwdParam.getNewPwd().equals(userPwdParam.getNewPwd2())) {
            return TupleRet.failed("两次密码输入不一致");
        }
        model.setPassword(MD5Util.md5(userPwdParam.getNewPwd()));

        try {
            userService.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("更新密码失败");
        }

        return TupleRet.success();
    }

    /**
     * 更新头像地址
     * @param avatarUrl
     * @return
     */
    @Override
    public TupleRet updateAvatarUrl(String avatarUrl) {
        var model = userService.getById(ApiContextHolder.getAuthDto().getUserId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("用户不存在");
        }

        try {
            model.setImg(avatarUrl);
            userService.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("更新失败");
        }

        return TupleRet.success();
    }

    /**
     * 某员工的手机号是否已存在
     * @param mobile
     * @return
     */
    @Override
    public Boolean existMobile(String mobile) {
        var emp = userService.getOne(new LambdaQueryWrapper<User>()
                .ne(User::getUserId, ApiContextHolder.getAuthDto().getUserId())
                .eq(User::getMobile, mobile));
        if (ObjectUtils.isEmpty(emp)){
            // 不存在
            return false;
        }
        // 已存在
        return true;
    }

    /**
     * 更新手机号
     * @param mobile
     * @return
     */
    @Override
    public TupleRet updateMobile(String mobile) {
        var model = userService.getById(ApiContextHolder.getAuthDto().getUserId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("用户不存在");
        }

        try {
            model.setMobile(mobile);
            userService.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("更新失败");
        }

        return TupleRet.success();
    }


    /**
     * 修改个人资料
     * @param userMyParam
     * @return
     */
    @Override
    public TupleRet editMy(UserMyParam userMyParam) {
        var model = userService.getById(ApiContextHolder.getAuthDto().getUserId());
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("用户不存在");
        }
        try {
            model.setUserName(userMyParam.getUserName());
            model.setNickName(userMyParam.getNickName());
            model.setEmail(userMyParam.getEmail());
            model.setGender(userMyParam.getGender());
            model.setBirthDate(userMyParam.getBirthDate());

            userService.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

}
