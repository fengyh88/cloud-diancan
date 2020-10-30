package com.fish.cloud.service;

import com.fish.cloud.bean.param.EmpMyParam;
import com.fish.cloud.bean.param.LoginParam;
import com.fish.cloud.bean.param.EmpAddParam;
import com.fish.cloud.bean.param.EmpPwdParam;
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
     * 登录
     *
     * @param loginParam
     * @return
     */
    public TupleRet<String> token(LoginParam loginParam);

    /**
     * 更新密码
     *
     * @param empPwdParam
     * @return
     */
    public TupleRet updatePassword(String empId, EmpPwdParam empPwdParam);

    /**
     * 更新头像地址
     *
     * @param avatarUrl
     * @return
     */
    public TupleRet updateAvatarUrl(String empId, String avatarUrl);

    /**
     * 某员工的手机号在某店铺是否已存在
     * @param empId
     * @param shopId
     * @param mobile
     * @return
     */
    public Boolean existMobile(String empId, String shopId, String mobile);

    /**
     * 更新手机号
     *
     * @param mobile
     * @return
     */
    public TupleRet updateMobile(String empId, String mobile);

    /**
     * 修改个人资料
     * @param empId
     * @param empMyParam
     * @return
     */
    public TupleRet editMy(String empId, EmpMyParam empMyParam);
}
