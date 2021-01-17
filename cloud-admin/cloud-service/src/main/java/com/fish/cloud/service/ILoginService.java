package com.fish.cloud.service;

import com.fish.cloud.bean.dto.LoginDto;
import com.fish.cloud.bean.param.EmpMyParam;
import com.fish.cloud.bean.param.EmpPwdParam;
import com.fish.cloud.bean.param.LoginParam;
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
    TupleRet<LoginDto> token(LoginParam loginParam);
}
