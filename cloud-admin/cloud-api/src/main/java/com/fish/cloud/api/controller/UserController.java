package com.fish.cloud.api.controller;

import com.fish.cloud.bean.param.UserLoginWxParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @ApiOperation("微信登录")
    @RequestMapping(value = "/loginWx",method = RequestMethod.POST)
    public TupleRet loginWx(@RequestBody UserLoginWxParam userLoginWxParam, HttpServletRequest httpServletRequest) {
        return userService.loginWx(userLoginWxParam);
    }
}
