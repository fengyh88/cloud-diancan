package com.fish.cloud.api.controller;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.SysMenuDto;
import com.fish.cloud.bean.model.RoleMenu;
import com.fish.cloud.bean.model.SysMenu;
import com.fish.cloud.bean.param.SysMenuAddParam;
import com.fish.cloud.bean.param.SysMenuParam;
import com.fish.cloud.bean.param.SysMenuEditParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IRoleMenuService;
import com.fish.cloud.service.ISysMenuService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统菜单
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Controller
@RequestMapping("/sys/menu")
public class SysMenuController {

    @Autowired
    private ISysMenuService sysMenuService;
    @Autowired
    private IRoleMenuService roleMenuService;

    @ApiOperation(value = "根据角色获取列表", notes = "根据角色获取列表")
    @PostMapping("/listByRoleId")
    @ResponseBody
    public ApiResult<List<SysMenuDto>> listByRoleId(@RequestBody SysMenuParam sysMenuParam) {
        if (0 == sysMenuParam.getRoleId()) {
            return ApiResult.failed("请传入角色Id");
        }

        List<SysMenu> modelList = sysMenuService.list(new LambdaQueryWrapper<SysMenu>()
                .eq(sysMenuParam.getMenuLevel() != 0, SysMenu::getMenuLevel, sysMenuParam.getMenuLevel())
                .eq(SysMenu::getStatus, 1));

        List<SysMenuDto> dtoList = modelList.stream().map(model -> {
            var dto = new SysMenuDto();
            BeanUtils.copyProperties(model, dto);
            int num = roleMenuService.count(new LambdaQueryWrapper<RoleMenu>()
                    .eq(RoleMenu::getRoleId, sysMenuParam.getRoleId())
                    .eq(RoleMenu::getMenuId, model.getMenuId()));
            if (num <= 0) {
                dto.setIsCheck(0);
            } else {
                dto.setIsCheck(1);
            }
            return dto;
        }).collect(Collectors.toList());

        return ApiResult.success(dtoList);
    }

    @ApiOperation(value = "获取N级别列表", notes = "获取N级别列表")
    @GetMapping("/listByNLevel")
    @ResponseBody
    public ApiResult<List<SysMenuDto>> listByNLevel(@RequestParam Long menuLevel) {
        List<SysMenu> modelList = sysMenuService.list(new LambdaQueryWrapper<SysMenu>()
                .eq(menuLevel != 0, SysMenu::getMenuLevel, menuLevel)
                .eq(SysMenu::getStatus, 1));

        List<SysMenuDto> dtoList = modelList.stream().map(model -> {
            var dto = new SysMenuDto();
            BeanUtils.copyProperties(model, dto);
            return dto;
        }).collect(Collectors.toList());

        // 返回
        return ApiResult.success(dtoList);
    }

    @ApiOperation(value = "根据Id获取下层级列表", notes = "根据Id获取下层级列表")
    @GetMapping("/listByPId")
    @ResponseBody
    public ApiResult<List<SysMenuDto>> listByPId(@RequestParam Long menuId) {
        List<SysMenu> modelList = sysMenuService.list(new LambdaQueryWrapper<SysMenu>()
                .eq(SysMenu::getPId, menuId)
                .eq(SysMenu::getStatus, 1));

        List<SysMenuDto> dtoList = modelList.stream().map(model -> {
            var dto = new SysMenuDto();
            BeanUtils.copyProperties(model, dto);
            return dto;
        }).collect(Collectors.toList());

        return ApiResult.success(dtoList);
    }

    @ApiOperation(value = "分页", notes = "分页")
    @GetMapping("/page")
    @ResponseBody
    public ApiResult<IPage<SysMenuDto>> page(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                             @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                             SysMenuParam sysMenuParam) {
        IPage<SysMenu> modelPage = sysMenuService.page(new Page<>(pageNo, pageSize), new LambdaQueryWrapper<SysMenu>()
                .eq(sysMenuParam.getMenuLevel() != 0, SysMenu::getMenuLevel, sysMenuParam.getMenuLevel())
                .ne(SysMenu::getStatus, -1));
        IPage<SysMenuDto> dtoPage = modelPage.convert(model -> Convert.convert(SysMenuDto.class, model));
        return ApiResult.success(dtoPage);
    }

    @ApiOperation(value = "添加", notes = "添加")
    @PostMapping("/add")
    @ResponseBody
    public ApiResult add(@Valid @RequestBody SysMenuAddParam sysMenuAddParam) {
        var ret = sysMenuService.add(sysMenuAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation(value = "编辑", notes = "编辑")
    @PostMapping("/edit")
    @ResponseBody
    public ApiResult edit(@Valid @RequestBody SysMenuEditParam sysMenuEditParam) {
        var ret = sysMenuService.edit(sysMenuEditParam);
        return ApiResult.fromTupleRet(ret);
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
        var ret = sysMenuService.status(id, status);
        return ApiResult.fromTupleRet(ret);
    }
}
