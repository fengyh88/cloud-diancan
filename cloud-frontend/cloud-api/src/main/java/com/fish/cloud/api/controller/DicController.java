package com.fish.cloud.api.controller;

import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.model.SysDic;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ISysDicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统字典
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "系统字典")
@RestController
@RequestMapping("/dic")
public class DicController {
    @Autowired
    private ISysDicService sysDicService;

    @ApiOperation("所有列表")
    @GetMapping(value = "/all")
    public ApiResult<List<SysDic>> all() {
        var dtos = sysDicService.all(ApiContextHolder.getShopId());
        return ApiResult.success(dtos);
    }
}

