package com.fish.cloud.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.model.Duty;
import com.fish.cloud.bean.param.DutyAddParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IDutyService;
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
 * 岗位
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "岗位")
@Controller
@RequestMapping("/api/duty")
public class DutyController {
    @Autowired
    private IDutyService dutyService;

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
    public ApiResult<IPage<Duty>> page(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                       @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize) {
        // 分页
        var models = dutyService.page(new Page<Duty>(pageNo, pageSize), new LambdaQueryWrapper<Duty>()
                .eq(Duty::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Duty::getStatus, 1));
        return ApiResult.success(models);
    }

    @ApiOperation(value = "列表", notes = "列表")
    @GetMapping(value = "/list")
    public ApiResult<List<Duty>> list() {
        // 列表
        var models = dutyService.list(new LambdaQueryWrapper<Duty>()
                .eq(Duty::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Duty::getStatus, 1));
        return ApiResult.success(models);
    }

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
        var ret = dutyService.add(dutyAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "dutyAddParam", value = "岗位信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody DutyAddParam dutyAddParam) {
        var ret = dutyService.edit(dutyAddParam);
        return ApiResult.fromTupleRet(ret);
    }
}
