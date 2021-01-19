package com.fish.cloud.api.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.SysConfigDto;
import com.fish.cloud.bean.model.SysConfig;
import com.fish.cloud.bean.param.SysConfigAddParam;
import com.fish.cloud.bean.param.SysConfigEditParam;
import com.fish.cloud.bean.param.SysConfigParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ISysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
@RequestMapping("/sys/config")
public class SysConfigController {
    @Autowired
    private ISysConfigService sysConfigService;

    @ApiOperation(value = "分页", notes = "分页")
    @GetMapping("/page")
    @ResponseBody
    public ApiResult<IPage<SysConfigDto>> page(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                               @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize,
                                               SysConfigParam sysConfigParam) {
        IPage<SysConfig> modelPage = sysConfigService.page(new Page<SysConfig>(pageNo, pageSize), new LambdaQueryWrapper<SysConfig>()
                .eq(SysConfig::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .and(wrapper -> wrapper.like(StrUtil.isNotEmpty(sysConfigParam.getKeywords()), SysConfig::getParamKey, sysConfigParam.getKeywords())
                        .or()
                        .like(StrUtil.isNotEmpty(sysConfigParam.getKeywords()), SysConfig::getRemark, sysConfigParam.getKeywords()))
                .ne(SysConfig::getStatus, -1));
        var dtoPage = modelPage.convert(model -> Convert.convert(SysConfigDto.class, model));
        return ApiResult.success(dtoPage);
    }

    @ApiOperation("全部")
    @GetMapping(value = "/all")
    public ApiResult<List<SysConfigDto>> all() {
        var models = sysConfigService.all();
        List<SysConfigDto> dtoList = models.stream().map(model -> {
            SysConfigDto dto = new SysConfigDto();
            BeanUtil.copyProperties(model, dto);
            return dto;
        }).collect(Collectors.toList());
        return ApiResult.success(dtoList);
    }

    @ApiOperation("根据key获取值")
    @ApiImplicitParam(name = "key", value = "key", required = true)
    @GetMapping(value = "/getByKey")
    public ApiResult<SysConfigDto> getByKey(String key) {
        var model = sysConfigService.getByKey(key);
        SysConfigDto dto = new SysConfigDto();
        BeanUtil.copyProperties(model, dto);
        return ApiResult.success(dto);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "sysConfigEditParam", value = "系统配置信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody SysConfigEditParam sysConfigEditParam) {
        var ret = sysConfigService.edit(sysConfigEditParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "sysConfigEditParam", value = "系统配置信息", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody SysConfigAddParam sysConfigAddParam) {
        var ret = sysConfigService.add(sysConfigAddParam);
        return ApiResult.fromTupleRet(ret);
    }
}
