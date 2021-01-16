package com.fish.cloud.api.controller;

import com.fish.cloud.bean.param.UserMyParam;
import com.fish.cloud.bean.param.UserPwdParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IMyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "我的")
@RequestMapping(value = "/my")
@RestController
public class MyController {
    @Autowired
    private IMyService myService;

    @ApiOperation("更新密码")
    @ApiImplicitParam(name = "empPwdParam", value = "密码信息", required = true)
    @PostMapping("/updatePassword")
    public ApiResult updatePassword(@RequestBody UserPwdParam empPwdParam) {
        var ret = myService.updatePassword(empPwdParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("更新头像地址")
    @ApiImplicitParam(name = "avatarUrl", value = "头像地址", required = true)
    @PostMapping("/updateAvatarUrl")
    public ApiResult updateAvatarUrl(@RequestBody String avatarUrl) {
        var ret = myService.updateAvatarUrl(avatarUrl);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("更新手机号")
    @ApiImplicitParam(name = "mobile", value = "手机号", required = true)
    @PostMapping("/updateMobile")
    public ApiResult updateMobile(@RequestBody String mobile) {
        Boolean exists = myService.existMobile(mobile);
        if (exists){
           return ApiResult.failed("该手机号已注册");
        }

        var ret = myService.updateMobile(mobile);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑个人信息")
    @ApiImplicitParam(name = "userMyParam", value = "可编辑的个人信息", required = true)
    @PostMapping(value = "/editMy")
    public ApiResult editMy(@RequestBody UserMyParam userMyParam) {
        var ret = myService.editMy(userMyParam);
        return ApiResult.fromTupleRet(ret);
    }
}
