package com.fish.cloud.api.controller;

import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.model.SysDicKv;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ISysDicKvService;
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
 * 系统字典kv
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "系统字典kv")
@RestController
@RequestMapping("/dicKv")
public class DicKvController {
    @Autowired
    private ISysDicKvService sysDicKvService;

    @ApiOperation("根据系统字典编码获取列表")
    @ApiImplicitParam(name = "dicCode", value = "系统字典编码", required = true)
    @GetMapping(value = "/listByDicCode")
    public ApiResult<List<SysDicKv>> listByDicCode(String dicCode) {
        var dtos = sysDicKvService.listByDicCode(ApiContextHolder.getShopId(), dicCode);
        return ApiResult.success(dtos);
    }
}
