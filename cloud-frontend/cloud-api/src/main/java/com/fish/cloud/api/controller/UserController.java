package com.fish.cloud.api.controller;

import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.dto.UserDto;
import com.fish.cloud.bean.param.UserLoginWxParam;
import com.fish.cloud.bean.param.UserMobileParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("更新手机号")
    @ApiImplicitParam(name = "userMobileParam", value = "用户手机更新信息", required = true)
    @RequestMapping(value = "/mobile", method = RequestMethod.POST)
    public ApiResult mobile(@RequestBody UserMobileParam userMobileParam) {
        var ret = userService.mobile(userMobileParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("详情")
    @GetMapping(value = "/detail")
    public ApiResult<UserDto> detail() {
        var dto = userService.detail(ApiContextHolder.getAuthDto().getUserId());
        return ApiResult.success(dto);
    }
}
