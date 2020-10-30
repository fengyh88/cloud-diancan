package com.fish.cloud.api.controller;

import com.fish.cloud.bean.param.AdminLoginParam;
import com.fish.cloud.common.util.TupleRet;
import com.fish.cloud.service.IEmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "",description = "")
@RequestMapping(value = "/admin/login")
@RestController
public class AdminLoginController {
    @Autowired
    private IEmpService empService;

    @ApiOperation("用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public TupleRet login(@RequestBody AdminLoginParam adminLoginParam) {
        return empService.login(adminLoginParam);
    }
}
