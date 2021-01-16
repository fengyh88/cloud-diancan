package com.fish.cloud.api.controller;

import com.fish.cloud.bean.param.LoginParam;
import com.fish.cloud.bean.param.UserLoginWxParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "登录")
@RequestMapping(value = "/login")
@RestController
public class LoginController {
    @Autowired
    private ILoginService loginService;

    @ApiOperation("token")
    @ApiImplicitParam(name = "loginParam", value = "登录信息", required = true)
    @PostMapping("/token")
    public ApiResult token(@RequestBody LoginParam loginParam) {
        var ret = loginService.token(loginParam);
        return ApiResult.fromTupleRet(ret);
    }

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
