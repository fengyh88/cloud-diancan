package com.fish.cloud.service;

import com.fish.cloud.bean.param.EmpMyParam;
import com.fish.cloud.bean.param.EmpPwdParam;
import com.fish.cloud.bean.param.LoginParam;
import com.fish.cloud.common.ret.TupleRet;

/**
 * <p>
 * 我的
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IMyService {
    /**
     * 更新密码
     *
     * @param empPwdParam
     * @return
     */
    TupleRet updatePassword(EmpPwdParam empPwdParam);
    /**
     * 更新手机号
     *
     * @param mobile
     * @return
     */
    TupleRet updateMobile(String mobile);
    /**
     * 编辑个人资料
     * @param empMyParam
     * @return
     */
    TupleRet edit(EmpMyParam empMyParam);
}
