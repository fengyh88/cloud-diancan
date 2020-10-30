package com.fish.cloud.api.controller;

import com.fish.cloud.bean.param.UserLoginWxParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 登录
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "登录")
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private ILoginService loginService;

    @ApiOperation("微信登录")
    @ApiImplicitParam(name = "userLoginWxParam", value = "登录信息", required = true)
    @RequestMapping(value = "/loginWx",method = RequestMethod.POST)
    public ApiResult<String> loginWx(@RequestBody UserLoginWxParam userLoginWxParam) {
        var ret = loginService.loginWx(userLoginWxParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("微信登录-仅登录")
    @ApiImplicitParam(name = "userLoginWxParam", value = "登录信息", required = true)
    @RequestMapping(value = "/loginWxOnly",method = RequestMethod.POST)
    public ApiResult<String> loginWxOnly(@RequestBody UserLoginWxParam userLoginWxParam) {
        var ret = loginService.loginWxOnly(userLoginWxParam);
        return ApiResult.fromTupleRet(ret);
    }
}
