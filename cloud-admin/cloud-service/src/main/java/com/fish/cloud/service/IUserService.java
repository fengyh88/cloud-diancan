package com.fish.cloud.service;

import com.fish.cloud.bean.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.UserLoginWxParam;
import com.fish.cloud.common.ret.TupleRet;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IUserService extends IService<User> {
    /**
     * 微信登录
     * @param userLoginWxParam
     * @return
     */
    public TupleRet loginWx(UserLoginWxParam userLoginWxParam);
}
