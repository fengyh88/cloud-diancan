package com.fish.cloud.api.controller;

import com.fish.cloud.bean.param.LoginParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
