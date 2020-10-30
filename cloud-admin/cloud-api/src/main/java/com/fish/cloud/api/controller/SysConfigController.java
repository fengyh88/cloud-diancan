package com.fish.cloud.api.controller;

import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.model.SysConfig;
import com.fish.cloud.bean.param.SysConfigEditParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ISysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统配置信息
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "系统配置信息")
@RestController
@RequestMapping("/api/sysConfig")
public class SysConfigController {
    @Autowired
    private ISysConfigService sysConfigService;

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "sysConfigEditParam", value = "系统配置信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody SysConfigEditParam sysConfigEditParam) {
        var ret = sysConfigService.edit(ApiContextHolder.getAuthDto().getShopId(),sysConfigEditParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("根据key获取值")
    @ApiImplicitParam(name = "key", value = "key", required = true)
    @GetMapping(value = "/getByKey")
    public ApiResult<SysConfig> getByKey(String key) {
        var dto = sysConfigService.getByKey(ApiContextHolder.getAuthDto().getShopId(), key);
        return ApiResult.success(dto);
    }

    @ApiOperation("所有列表")
    @GetMapping(value = "/all")
    public ApiResult<List<SysConfig>> all() {
        var dtos = sysConfigService.all(ApiContextHolder.getAuthDto().getShopId());
        return ApiResult.success(dtos);
    }
}
