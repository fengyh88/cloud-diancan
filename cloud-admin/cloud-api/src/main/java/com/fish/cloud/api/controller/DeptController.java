package com.fish.cloud.api.controller;

import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.model.Dept;
import com.fish.cloud.bean.param.DeptAddParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IDeptService;
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
 * 部门
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "部门")
@RestController
@RequestMapping("/api/dept")
public class DeptController {
    @Autowired
    private IDeptService deptService;

    @ApiOperation("更改状态，正常禁用删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "部门Id", required = true),
            @ApiImplicitParam(name = "status", value = "状态 -1删除 0禁用 1启用", required = true)
    })
    @GetMapping(value = "/updateStatus")
    public ApiResult updateStatus(@RequestParam("id") long id, @RequestParam("status") Integer status) {
        if (!ArrayUtils.contains(new int[]{-1, 0, 1}, status)) {
            return ApiResult.failed("需传入-1删除 0禁用 1启用");
        }
        var ret = deptService.updateStatus(id, status);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "deptAddParam", value = "部门信息", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody DeptAddParam deptAddParam) {
        var ret = deptService.add(ApiContextHolder.getAuthDto().getShopId(),deptAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "deptAddParam", value = "部门信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody DeptAddParam deptAddParam) {
        var ret = deptService.edit(ApiContextHolder.getAuthDto().getShopId(),deptAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("所有列表")
    @GetMapping(value = "/all")
    public ApiResult<List<Dept>> all() {
        var dtos = deptService.all(ApiContextHolder.getAuthDto().getShopId());
        return ApiResult.success(dtos);
    }
}
