package com.fish.cloud.api.controller;

import com.fish.cloud.bean.param.EmpMyParam;
import com.fish.cloud.bean.param.EmpPwdParam;
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
    @ApiImplicitParam(name = "empPwdParam", value = "密码", required = true)
    @PostMapping("/update/password")
    public ApiResult updatePassword(@RequestBody EmpPwdParam empPwdParam) {
        var ret = myService.updatePassword(empPwdParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("更新手机号")
    @ApiImplicitParam(name = "mobile", value = "手机号", required = true)
    @PostMapping("/update/mobile")
    public ApiResult updateMobile(@RequestBody String mobile) {
        var ret = myService.updateMobile(mobile);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑个人信息")
    @ApiImplicitParam(name = "empMyParam", value = "个人信息", required = true)
    @PostMapping(value = "/edit")
    public ApiResult edit(@RequestBody EmpMyParam empMyParam) {
        var ret = myService.edit(empMyParam);
        return ApiResult.fromTupleRet(ret);
    }
}
