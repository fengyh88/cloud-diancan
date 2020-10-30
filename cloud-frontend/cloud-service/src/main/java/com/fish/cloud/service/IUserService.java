package com.fish.cloud.service;

import com.fish.cloud.bean.dto.UserDto;
import com.fish.cloud.bean.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.UserMobileParam;
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
     * 绑定手机号
     *
     * @param userMobileParam
     * @return
     */
    TupleRet mobile(UserMobileParam userMobileParam);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    UserDto detail(String id);
}
