package com.fish.cloud.api.controller;

import com.fish.cloud.bean.model.Role;
import com.fish.cloud.bean.param.RoleAddParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IRoleService;
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
 * 角色
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "角色")
@Controller
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @ApiOperation("所有列表")
    @GetMapping(value = "/all")
    public ApiResult<List<Role>> all() {
        var dtos = roleService.all();
        return ApiResult.success(dtos);
    }

    @ApiOperation("更改状态，正常禁用删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色Id", required = true),
            @ApiImplicitParam(name = "status", value = "状态 -1删除 0禁用 1启用", required = true)
    })
    @GetMapping(value = "/updateStatus")
    public ApiResult updateStatus(@RequestParam("id") long id, @RequestParam("status") Integer status) {
        if (!ArrayUtils.contains(new int[]{-1, 0, 1}, status)) {
            return ApiResult.failed("需传入-1删除 0禁用 1启用");
        }
        var ret = roleService.updateStatus(id, status);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "roleAddParam", value = "角色信息", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody RoleAddParam roleAddParam) {
        var ret = roleService.add(roleAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "roleAddParam", value = "角色信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody RoleAddParam roleAddParam) {
        var ret = roleService.edit(roleAddParam);
        return ApiResult.fromTupleRet(ret);
    }
}
