package com.fish.cloud.api.controller;

import cn.hutool.core.bean.BeanUtil;
import com.fish.cloud.bean.dto.SysDicDto;
import com.fish.cloud.bean.dto.SysDicKvDto;
import com.fish.cloud.bean.model.SysDicKv;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ISysDicKvService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统字典kv
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "系统字典kv")
@Controller
@RequestMapping("/sysDicKv")
public class SysDicKvController {
    @Autowired
    private ISysDicKvService sysDicKvService;

    @ApiOperation("根据系统字典编码获取列表")
    @ApiImplicitParam(name = "dicCode", value = "系统字典编码", required = true)
    @GetMapping(value = "/listByDicCode")
    public ApiResult<List<SysDicKvDto>> listByDicCode(String dicCode) {
        var models = sysDicKvService.listByDicCode(dicCode);
        List<SysDicKvDto> dtoList = models.stream().map(model -> {
            SysDicKvDto dto = new SysDicKvDto();
            BeanUtil.copyProperties(model, dto);
            return dto;
        }).collect(Collectors.toList());
        return ApiResult.success(dtoList);
    }

    @ApiOperation("所有列表")
    @GetMapping(value = "/all")
    public ApiResult<List<SysDicKvDto>> all() {
        var models = sysDicKvService.all();
        List<SysDicKvDto> dtoList = models.stream().map(model -> {
            var dto = new SysDicKvDto();
            BeanUtil.copyProperties(model, dto);
            return dto;
        }).collect(Collectors.toList());
        return ApiResult.success(dtoList);
    }
}
