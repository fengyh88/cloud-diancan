package com.fish.cloud.api.controller;

import com.fish.cloud.bean.model.SysConfig;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ISysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 系统配置信息
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "系统配置信息")
@Controller
@RequestMapping("/sysConfig")
public class SysConfigController {
    @Autowired
    private ISysConfigService sysConfigService;

    @ApiOperation("所有列表")
    @GetMapping(value = "/all")
    public ApiResult<List<SysConfig>> all() {
        var dtoList = sysConfigService.all();
        return ApiResult.success(dtoList);
    }

    @ApiOperation("根据key获取值")
    @ApiImplicitParam(name = "key", value = "key", required = true)
    @GetMapping(value = "/getByKey")
    public ApiResult<SysConfig> getByKey(String key) {
        var dto = sysConfigService.getByKey(key);
        return ApiResult.success(dto);
    }
}
