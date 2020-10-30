package com.fish.cloud.api.controller;

import com.fish.cloud.api.config.ConfigBeanValue;
import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.dto.MpAppConfDto;
import com.fish.cloud.bean.model.SysConfig;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ISysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/sysConfig")
public class SysConfigController {

    @Autowired
    private ConfigBeanValue configBeanValue;

    @Autowired
    private ISysConfigService sysConfigService;

    @ApiOperation("根据key获取值")
    @ApiImplicitParam(name = "key", value = "key", required = true)
    @GetMapping(value = "/getByKey")
    public ApiResult<SysConfig> getByKey(String key) {
        var dto = sysConfigService.getByKey(ApiContextHolder.getShopId(), key);
        return ApiResult.success(dto);
    }

    @ApiOperation("所有列表")
    @GetMapping(value = "/all")
    public ApiResult<List<SysConfig>> all() {
        var dtos = sysConfigService.all(ApiContextHolder.getShopId());
        return ApiResult.success(dtos);
    }

    @ApiOperation("小程序配置")
    @GetMapping(value = "/mpAppConf")
    public ApiResult<MpAppConfDto> mpAppConf() {
        MpAppConfDto dto = new MpAppConfDto();
        dto.setAppName(sysConfigService.getByKey(configBeanValue.shopId, "mpAppName").getParamValue());
        dto.setAppDesc(sysConfigService.getByKey(configBeanValue.shopId, "mpAppDesc").getParamValue());
        dto.setAppVersion(sysConfigService.getByKey(configBeanValue.shopId, "mpAppVersion").getParamValue());
        dto.setAppLogo(sysConfigService.getByKey(configBeanValue.shopId, "mpAppLogo").getParamValue());
        return ApiResult.success(dto);
    }
}
