package com.fish.cloud.api.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.ProdDto;
import com.fish.cloud.bean.model.Order;
import com.fish.cloud.bean.model.SysConfig;
import com.fish.cloud.bean.param.ProdByCateParam;
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

    /**
     * 分页
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页", notes = "分页")
    @GetMapping("/page")
    @ResponseBody
    public ApiResult<IPage<SysConfig>> page(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize,
                                                SysConfigParam sysConfigParam) {
        // 分页
        IPage<SysConfig> models = sysConfigService.page(new Page<SysConfig>(pageNo, pageSize), new LambdaQueryWrapper<SysConfig>()
                .eq(SysConfig::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .and(wrapper -> wrapper.like(StrUtil.isNotEmpty(sysConfigParam.getKeywords()), SysConfig::getParamKey, sysConfigParam.getKeywords())
                        .or()
                        .like(StrUtil.isNotEmpty(sysConfigParam.getKeywords()), SysConfig::getRemark, sysConfigParam.getKeywords()))
                .eq(SysConfig::getStatus, 1));
        return ApiResult.success(models);
    }

    @ApiOperation("列表")
    @GetMapping(value = "/list")
    public ApiResult<List<SysConfig>> list() {
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

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "sysConfigEditParam", value = "系统配置信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody SysConfigEditParam sysConfigEditParam) {
        var ret = sysConfigService.edit(sysConfigEditParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("新增")
    @ApiImplicitParam(name = "sysConfigEditParam", value = "系统配置信息", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody SysConfigAddParam sysConfigAddParam) {
        var ret = sysConfigService.add(sysConfigAddParam);
        return ApiResult.fromTupleRet(ret);
    }
}
