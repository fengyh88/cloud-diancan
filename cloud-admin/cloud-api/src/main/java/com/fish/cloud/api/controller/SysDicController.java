package com.fish.cloud.api.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.model.SysConfig;
import com.fish.cloud.bean.model.SysDic;
import com.fish.cloud.bean.param.SysConfigParam;
import com.fish.cloud.bean.param.SysDicAddParam;
import com.fish.cloud.bean.param.SysDicParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ISysDicService;
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
 * 系统字典
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "系统字典")
@Controller
@RequestMapping("/sysDic")
public class SysDicController {
    @Autowired
    private ISysDicService sysDicService;

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
    public ApiResult<IPage<SysDic>> page(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                            @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize,
                                         SysDicParam sysDicParam) {
        // 分页
        IPage<SysDic> models = sysDicService.page(new Page<SysDic>(pageNo, pageSize), new LambdaQueryWrapper<SysDic>()
                .eq(SysDic::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .and(wrapper -> wrapper.like(StrUtil.isNotEmpty(sysDicParam.getKeywords()), SysDic::getDicCode, sysDicParam.getKeywords())
                        .or()
                        .like(StrUtil.isNotEmpty(sysDicParam.getKeywords()), SysDic::getDicName, sysDicParam.getKeywords())
                        .or()
                        .like(StrUtil.isNotEmpty(sysDicParam.getKeywords()), SysDic::getRemark, sysDicParam.getKeywords()))
                .eq(SysDic::getStatus, 1));
        return ApiResult.success(models);
    }

    @ApiOperation("列表")
    @GetMapping(value = "/list")
    public ApiResult<List<SysDic>> list() {
        var dtoList = sysDicService.all();
        return ApiResult.success(dtoList);
    }

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
        var ret = sysDicService.add(sysDicAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "sysDicAddParam", value = "系统字典信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody SysDicAddParam sysDicAddParam) {
        var ret = sysDicService.edit(sysDicAddParam);
        return ApiResult.fromTupleRet(ret);
    }
}
