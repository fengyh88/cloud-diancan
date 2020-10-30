package com.fish.cloud.api.controller;

import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.param.EmpMyParam;
import com.fish.cloud.bean.param.LoginParam;
import com.fish.cloud.bean.param.EmpPwdParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "登录")
@RequestMapping(value = "/api/login")
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

    @ApiOperation("更新密码")
    @ApiImplicitParam(name = "empPwdParam", value = "密码信息", required = true)
    @PostMapping("/updatePassword")
    public ApiResult updatePassword(@RequestBody EmpPwdParam empPwdParam) {
        var ret = loginService.updatePassword(ApiContextHolder.getAuthDto().getEmpId(), empPwdParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("更新头像地址")
    @ApiImplicitParam(name = "avatarUrl", value = "头像地址", required = true)
    @PostMapping("/updateAvatarUrl")
    public ApiResult updateAvatarUrl(@RequestBody String avatarUrl) {
        var ret = loginService.updateAvatarUrl(ApiContextHolder.getAuthDto().getEmpId(),avatarUrl);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("更新手机号")
    @ApiImplicitParam(name = "mobile", value = "手机号", required = true)
    @PostMapping("/updateMobile")
    public ApiResult updateMobile(@RequestBody String mobile) {
        Boolean exists = loginService.existMobile(ApiContextHolder.getAuthDto().getEmpId(),ApiContextHolder.getAuthDto().getShopId(),mobile);
        if (exists){
           return ApiResult.failed("该手机号已注册");
        }

        var ret = loginService.updateMobile(ApiContextHolder.getAuthDto().getEmpId(), mobile);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑个人信息")
    @ApiImplicitParam(name = "empMyParam", value = "可编辑的个人信息", required = true)
    @PostMapping(value = "/editMy")
    public ApiResult editMy(@RequestBody EmpMyParam empMyParam) {
        var ret = loginService.editMy(ApiContextHolder.getAuthDto().getEmpId(), empMyParam);
        return ApiResult.fromTupleRet(ret);
    }
}
