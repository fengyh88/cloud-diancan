package com.fish.cloud.api.controller;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.CallDto;
import com.fish.cloud.bean.model.Call;
import com.fish.cloud.bean.model.Dept;
import com.fish.cloud.bean.param.DeptAddParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IDeptService;
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
 * 部门
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "部门")
@Controller
@RequestMapping("/api/dept")
public class DeptController {
    @Autowired
    private IDeptService deptService;

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
    public ApiResult<IPage<Dept>> page(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                       @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize) {
        // 分页
        IPage<Dept> models = deptService.page(new Page<Dept>(pageNo, pageSize), new LambdaQueryWrapper<Dept>()
                .eq(Dept::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Dept::getStatus, 1));
        return ApiResult.success(models);
    }

    @ApiOperation(value = "列表", notes = "列表")
    @GetMapping(value = "/list")
    public ApiResult<List<Dept>> list() {
        // 列表
        var models = deptService.list(new LambdaQueryWrapper<Dept>()
                .eq(Dept::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Dept::getStatus, 1));
        return ApiResult.success(models);
    }

    @ApiOperation("更改状态，正常禁用删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
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
        var ret = deptService.add(deptAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "deptAddParam", value = "部门信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody DeptAddParam deptAddParam) {
        var ret = deptService.edit(deptAddParam);
        return ApiResult.fromTupleRet(ret);
    }
}
