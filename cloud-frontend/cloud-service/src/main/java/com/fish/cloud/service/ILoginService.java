package com.fish.cloud.service;

import com.fish.cloud.bean.param.UserLoginWxParam;
import com.fish.cloud.common.ret.TupleRet;

/**
 * <p>
 * 登录
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface ILoginService {

    /**
     * 微信登录
     * @param userLoginWxParam
     * @return
     */
    TupleRet loginWx(UserLoginWxParam userLoginWxParam);

    /**
     * 微信登录-仅登录
     * @param userLoginWxParam
     * @return
     */
    TupleRet loginWxOnly(UserLoginWxParam userLoginWxParam);
}
