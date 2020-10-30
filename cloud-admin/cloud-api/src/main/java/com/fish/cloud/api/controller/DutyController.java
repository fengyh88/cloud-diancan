package com.fish.cloud.api.controller;

import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.model.Duty;
import com.fish.cloud.bean.param.DutyAddParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IDutyService;
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
 * 岗位
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "岗位")
@RestController
@RequestMapping("/api/duty")
public class DutyController {
    @Autowired
    private IDutyService dutyService;

    @ApiOperation("更改状态，正常禁用删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "岗位Id", required = true),
            @ApiImplicitParam(name = "status", value = "状态 -1删除 0禁用 1启用", required = true)
    })
    @GetMapping(value = "/updateStatus")
    public ApiResult updateStatus(@RequestParam("id") long id, @RequestParam("status") Integer status) {
        if (!ArrayUtils.contains(new int[]{-1, 0, 1}, status)) {
            return ApiResult.failed("需传入-1删除 0禁用 1启用");
        }
        var ret = dutyService.updateStatus(id, status);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "dutyAddParam", value = "岗位信息", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody DutyAddParam dutyAddParam) {
        var ret = dutyService.add(ApiContextHolder.getAuthDto().getShopId(),dutyAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "dutyAddParam", value = "岗位信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody DutyAddParam dutyAddParam) {
        var ret = dutyService.edit(ApiContextHolder.getAuthDto().getShopId(),dutyAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "岗位Id", required = true)
    @GetMapping(value = "/detail")
    public ApiResult<Duty> detail(@RequestParam(value = "id") long id) {
        var dto = dutyService.detail(id);
        return ApiResult.success(dto);
    }

    @ApiOperation("所有列表")
    @GetMapping(value = "/all")
    public ApiResult<List<Duty>> all() {
        var dtos = dutyService.all(ApiContextHolder.getAuthDto().getShopId());
        return ApiResult.success(dtos);
    }
}
