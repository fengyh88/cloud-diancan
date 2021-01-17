package com.fish.cloud.api.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.RoleDto;
import com.fish.cloud.bean.model.Role;
import com.fish.cloud.bean.param.RoleAddParam;
import com.fish.cloud.bean.param.RoleMenuParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IRoleMenuService;
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

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IRoleMenuService roleMenuService;

    @ApiOperation(value = "列表", notes = "列表")
    @GetMapping(value = "/list")
    public ApiResult<List<RoleDto>> list() {
        var models = roleService.list(new LambdaQueryWrapper<Role>()
                .eq(Role::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Role::getStatus, 1));
        var dtoList = models.stream().map(model -> {
            var dto = new RoleDto();
            BeanUtil.copyProperties(model, dto);
            return dto;
        }).collect(Collectors.toList());
        return ApiResult.success(dtoList);
    }

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
    public ApiResult<IPage<RoleDto>> page(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                          @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize) {
        IPage<Role> modelPage = roleService.page(new Page<Role>(pageNo, pageSize), new LambdaQueryWrapper<Role>()
                .eq(Role::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .ne(Role::getStatus, -1));
        IPage<RoleDto> dtoPage = modelPage.convert(model -> Convert.convert(RoleDto.class, model));
        return ApiResult.success(dtoPage);
    }

    @ApiOperation("更改状态，正常禁用删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色Id", required = true),
            @ApiImplicitParam(name = "status", value = "状态 -1删除 0禁用 1启用", required = true)
    })
    @GetMapping(value = "/status")
    public ApiResult status(@RequestParam("id") long id, @RequestParam("status") Integer status) {
        if (!ArrayUtils.contains(new int[]{-1, 0, 1}, status)) {
            return ApiResult.failed("需传入-1删除 0禁用 1启用");
        }
        var ret = roleService.status(id, status);
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

    @ApiOperation(value = "绑定菜单", notes = "绑定菜单")
    @PostMapping("/bindMenus")
    @ResponseBody
    public ApiResult bindMenus(@Valid @RequestBody RoleMenuParam roleMenuParam) {
        roleMenuService.bindRoleMenus(roleMenuParam.getRoleId(),roleMenuParam.getMenuIds());
        return ApiResult.success();
    }
}
