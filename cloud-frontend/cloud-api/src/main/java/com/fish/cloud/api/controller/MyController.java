package com.fish.cloud.api.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fish.cloud.bean.dto.UserDto;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IMyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "我的")
@RequestMapping(value = "/my")
@RestController
public class MyController {
    @Autowired
    private IMyService myService;

    @ApiOperation("获取个人信息")
    @GetMapping(value = "/info")
    public ApiResult<UserDto> info() {
        var model = myService.info();
        if (ObjectUtil.isNull(model)){
            return ApiResult.failed("用户信息不存在");
        }
        var dto = new UserDto();
        BeanUtil.copyProperties(model,dto);
        return ApiResult.success(dto);
    }
}
