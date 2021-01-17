package com.fish.cloud.api.controller;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.SysMenuDto;
import com.fish.cloud.bean.model.SysMenu;
import com.fish.cloud.bean.param.SysPermissionAddInput;
import com.fish.cloud.bean.param.SysPermissionChangeStatusInput;
import com.fish.cloud.bean.param.SysPermissionListInput;
import com.fish.cloud.bean.param.SysPermissionUpdateInput;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IRoleMenuService;
import com.fish.cloud.service.ISysMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    /**
     * 获取菜单列表
     *
     * @param input
     * @return
     */
    @ApiOperation(value = "获取菜单列表", notes = "获取菜单列表")
    @GetMapping("/queryPageList")
    @ResponseBody
    public ApiResult<IPage<SysMenuDto>> queryPageList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                      SysPermissionListInput input) {

        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(input.getTitle())) {
            queryWrapper.like("title", input.getTitle());
        }
        if (StringUtils.isNotEmpty(input.getUrl())) {
            queryWrapper.like("url", input.getUrl());
        }
        queryWrapper.eq("delete_flag", 0);
        Page<SysMenu> page = new Page<>(pageNo, pageSize);
        IPage<SysMenu> pageList = sysMenuService.page(page, queryWrapper);
        IPage<SysMenuDto> result = pageList.convert(sysPermission -> Convert.convert(SysMenuDto.class, sysPermission));
        // 返回
        return ApiResult.success(result);
    }

    /**
     * 新增菜单
     *
     * @param input
     * @return
     */
    @ApiOperation(value = "新增菜单", notes = "新增菜单")
    @PostMapping("/add")
    @ResponseBody
    public ApiResult add(@Valid @RequestBody SysPermissionAddInput input) {
        try {
            SysMenu sysPermission = new SysMenu();
            BeanUtils.copyProperties(input, sysPermission);
            sysPermission.setSubmitAccount(ApiContextHolder.getAuthDto().getAccountCode());
            this.sysMenuService.save(sysPermission);
        } catch (Exception e) {
            if (e.getMessage().indexOf("重复键") != -1) {
                return ApiResult.failed("菜单编码重复！");
            } else {
                return ApiResult.failed("新增失败，请联系管理员!");
            }

        }


        // 返回
        return ApiResult.success();
    }

    /**
     * 菜单信息更新
     *
     * @param input
     * @return
     */
    @ApiOperation(value = "菜单信息更新", notes = "菜单信息更新")
    @PostMapping("/update")
    @ResponseBody
    public ApiResult update(@Valid @RequestBody SysPermissionUpdateInput input) {

        SysMenu sysPermission = new SysMenu();
        BeanUtils.copyProperties(input, sysPermission);
        sysPermission.setUpdateTime(new Date());
        this.sysMenuService.updateById(sysPermission);

        // 返回
        return ApiResult.success();
    }

    /**
     * 菜单删除
     *
     * @param input
     * @return
     */
    @ApiOperation(value = "菜单删除", notes = "菜单删除")
    @PostMapping("/del")
    @ResponseBody
    public ApiResult del(@Valid @RequestBody SysPermissionChangeStatusInput input) {

        SysMenu sysPermission = new SysMenu();
        sysPermission.setId(input.getId());
        sysPermission.setDeleteFlag(input.getDeleteFlag());
        sysPermission.setUpdateTime(new Date());

        this.sysMenuService.updateById(sysPermission);

        // 返回
        return ApiResult.success();
    }

    /**
     * 获取角色菜单列表
     *
     * @param input
     * @return
     */
    @ApiOperation(value = "获取角色菜单列表", notes = "获取角色菜单列表")
    @GetMapping("/queryListForRole")
    @ResponseBody
    public ApiResult<List<SysMenuDto>> queryListForRole(SysPermissionListInput input) {
        if (StringUtils.isEmpty(input.getRoleCode())) {
            return ApiResult.success();
        }
        List<SysMenu> permissionList = sysMenuService.list(new LambdaQueryWrapper<SysMenu>()
                .eq(SysMenu::getDeleteFlag, false)
                .eq(SysMenu::getPermsType, "1"));
        ArrayList<SysPermissionListOutput> result = new ArrayList<>();

        for (SysMenu permission : permissionList) {
//            sysRolePermissionService
            SysMenuDto output = new SysMenuDto();
            BeanUtils.copyProperties(permission, output);
            int num = roleMenuService.count(new LambdaQueryWrapper<SysRolePermission>()
                    .eq(SysRolePermission::getRoleCode, input.getRoleCode())
                    .eq(SysRolePermission::getPerms, permission.getPerms()));
            if (num <= 0) {
                output.setIsCheck(0);
            } else {
                output.setIsCheck(1);
            }
            result.add(output);
        }

        // 返回
        return ApiResult.success(result);
    }

    /**
     * 根据类型获取菜单列表
     *
     * @param input
     * @return
     */
    @ApiOperation(value = "根据类型获取菜单列表", notes = "默认获取一级菜单")
    @GetMapping("/queryListForType")
    @ResponseBody
    public ApiResult<List<SysMenuDto>> queryListForType(SysPermissionListInput input) {

        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(input.getMenuType())) {
            queryWrapper.eq("menu_type", input.getMenuType());
        } else {
            queryWrapper.eq("menu_type", 0);
        }
        queryWrapper.eq("delete_flag", 0);
        queryWrapper.eq("perms_type", "1");
        List<SysMenu> permissionList = sysMenuService.list(queryWrapper);

        ArrayList<SysMenuDto> result = new ArrayList<>();

        for (SysMenu permission : permissionList) {
            SysMenuDto output = new SysMenuDto();
            BeanUtils.copyProperties(permission, output);
            result.add(output);
        }

        // 返回
        return ApiResult.success(result);
    }
}
