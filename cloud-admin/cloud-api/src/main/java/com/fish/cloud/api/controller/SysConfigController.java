package com.fish.cloud.api.controller;

import com.fish.cloud.bean.model.SysConfig;
import com.fish.cloud.bean.param.SysConfigEditParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ISysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
@RequestMapping("/api/sysConfig")
public class SysConfigController {
    @Autowired
    private ISysConfigService sysConfigService;

    @ApiOperation("所有列表")
    @GetMapping(value = "/all")
    public ApiResult<List<SysConfig>> all() {
        var dtos = sysConfigService.all();
        return ApiResult.success(dtos);
    }

    @ApiOperation("根据key获取值")
    @ApiImplicitParam(name = "key", value = "key", required = true)
    @GetMapping(value = "/getByKey")
    public ApiResult<SysConfig> getByKey(String key) {
        var dto = sysConfigService.getByKey(key);
        return ApiResult.success(dto);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "sysConfigEditParam", value = "系统配置信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody SysConfigEditParam sysConfigEditParam) {
        var ret = sysConfigService.edit(sysConfigEditParam);
        return ApiResult.fromTupleRet(ret);
    }
}
