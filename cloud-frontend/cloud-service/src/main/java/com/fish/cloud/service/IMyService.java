package com.fish.cloud.service;

import com.fish.cloud.bean.param.UserMyParam;
import com.fish.cloud.bean.param.UserPwdParam;
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
    TupleRet updatePassword(UserPwdParam empPwdParam);

    /**
     * 更新头像地址
     *
     * @param avatarUrl
     * @return
     */
    TupleRet updateAvatarUrl(String avatarUrl);

    /**
     * 某员工的手机号在当前店铺是否已存在
     * @param mobile
     * @return
     */
    Boolean existMobile(String mobile);

    /**
     * 更新手机号
     *
     * @param mobile
     * @return
     */
    TupleRet updateMobile(String mobile);

    /**
     * 修改个人资料
     * @param empMyParam
     * @return
     */
    TupleRet editMy(UserMyParam empMyParam);
}
