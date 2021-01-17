package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.User;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.service.IMyService;
import com.fish.cloud.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * 获取个人信息
     * @param
     * @return
     */
    @Override
    public User info() {
        return userService.getById(ApiContextHolder.getAuthDto().getUserId());
    }

}
