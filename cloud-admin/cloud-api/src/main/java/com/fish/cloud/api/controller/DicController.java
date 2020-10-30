package com.fish.cloud.api.controller;

import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.model.SysDic;
import com.fish.cloud.bean.param.SysDicAddParam;
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
@RequestMapping("/api/dic")
public class DicController {
    @Autowired
    private ISysDicService sysDicService;

    @ApiOperation("更改状态，正常禁用删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "系统字典Id", required = true),
            @ApiImplicitParam(name = "status", value = "状态 -1删除 0禁用 1启用", required = true)
    })
    @GetMapping(value = "/updateStatus")
    public ApiResult updateStatus(@RequestParam("id") long id, @RequestParam("status") Integer status) {
        if (!ArrayUtils.contains(new int[]{-1, 0, 1}, status)) {
            return ApiResult.failed("需传入-1删除 0禁用 1启用");
        }
        var ret = sysDicService.updateStatus(id, status);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "sysDicAddParam", value = "系统字典信息", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody SysDicAddParam sysDicAddParam) {
        var ret = sysDicService.add(ApiContextHolder.getAuthDto().getShopId(),sysDicAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "sysDicAddParam", value = "系统字典信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody SysDicAddParam sysDicAddParam) {
        var ret = sysDicService.edit(ApiContextHolder.getAuthDto().getShopId(),sysDicAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("所有列表")
    @GetMapping(value = "/all")
    public ApiResult<List<SysDic>> all() {
        var dtos = sysDicService.all(ApiContextHolder.getAuthDto().getShopId());
        return ApiResult.success(dtos);
    }
}
