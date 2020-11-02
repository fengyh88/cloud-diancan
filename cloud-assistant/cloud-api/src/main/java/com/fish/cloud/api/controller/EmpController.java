package com.fish.cloud.api.controller;

import com.fish.cloud.bean.dto.EmpDto;
import com.fish.cloud.bean.param.EmpAddParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IEmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 员工
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "员工")
@Controller
@RequestMapping("/api/emp")
public class EmpController {
    @Autowired
    private IEmpService empService;

    @ApiOperation("所有列表")
    @GetMapping(value = "/all")
    public ApiResult<List<EmpDto>> all() {
        var dtos = empService.all();
        return ApiResult.success(dtos);
    }

    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "员工Id", required = true)
    @GetMapping(value = "/detail")
    public ApiResult<EmpDto> detail(@RequestParam(value = "id") long id) {
        var dto = empService.detail(id);
        return ApiResult.success(dto);
    }
    @ApiOperation("更改状态，正常禁用删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "员工Id", required = true),
            @ApiImplicitParam(name = "status", value = "状态 -1删除 0禁用 1启用", required = true)
    })
    @GetMapping(value = "/updateStatus")
    public ApiResult updateStatus(@RequestParam("id") long id, @RequestParam("status") Integer status) {
        if (!ArrayUtils.contains(new int[]{-1, 0, 1}, status)) {
            return ApiResult.failed("需传入-1删除 0禁用 1启用");
        }
        var ret = empService.updateStatus(id, status);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "empAddParam", value = "员工信息", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody EmpAddParam empAddParam) {
        var ret = empService.add(empAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "empAddParam", value = "员工信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody EmpAddParam empAddParam) {
        var ret = empService.edit(empAddParam);
        return ApiResult.fromTupleRet(ret);
    }
}
