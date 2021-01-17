package com.fish.cloud.api.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.model.SysDic;
import com.fish.cloud.bean.model.SysDicKv;
import com.fish.cloud.bean.param.SysDicKvAddParam;
import com.fish.cloud.bean.param.SysDicKvParam;
import com.fish.cloud.bean.param.SysDicParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ISysDicKvService;
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
 * 系统字典kv
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "系统字典kv")
@Controller
@RequestMapping("/sysDicKv")
public class SysDicKvController {
    @Autowired
    private ISysDicKvService sysDicKvService;

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
    public ApiResult<IPage<SysDicKv>> page(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                         @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize,
                                           SysDicKvParam sysDicKvParam) {
        // 分页
        IPage<SysDicKv> models = sysDicKvService.page(new Page<SysDicKv>(pageNo, pageSize), new LambdaQueryWrapper<SysDicKv>()
                .eq(SysDicKv::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(StrUtil.isNotEmpty(sysDicKvParam.getDicCode()), SysDicKv::getDicCode, sysDicKvParam.getDicCode())
                .and(wrapper -> wrapper.like(StrUtil.isNotEmpty(sysDicKvParam.getKeywords()), SysDicKv::getKey, sysDicKvParam.getKeywords())
                        .or()
                        .like(StrUtil.isNotEmpty(sysDicKvParam.getKeywords()), SysDicKv::getValue, sysDicKvParam.getKeywords())
                        .or()
                        .like(StrUtil.isNotEmpty(sysDicKvParam.getKeywords()), SysDicKv::getRemark, sysDicKvParam.getKeywords()))
                .eq(SysDicKv::getStatus, 1));
        return ApiResult.success(models);
    }

    @ApiOperation("根据系统字典编码获取列表")
    @ApiImplicitParam(name = "dicCode", value = "系统字典编码", required = true)
    @GetMapping(value = "/listByDicCode")
    public ApiResult<List<SysDicKv>> listByDicCode(String dicCode) {
        var models = sysDicKvService.listByDicCode(dicCode);
        return ApiResult.success(models);
    }

    @ApiOperation("更改状态，正常禁用删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "系统字典kvId", required = true),
            @ApiImplicitParam(name = "status", value = "状态 -1删除 0禁用 1启用", required = true)
    })
    @GetMapping(value = "/updateStatus")
    public ApiResult updateStatus(@RequestParam("id") long id, @RequestParam("status") Integer status) {
        if (!ArrayUtils.contains(new int[]{-1, 0, 1}, status)) {
            return ApiResult.failed("需传入-1删除 0禁用 1启用");
        }
        var ret = sysDicKvService.updateStatus(id, status);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "sysDicKvAddParam", value = "系统字典kv信息", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody SysDicKvAddParam sysDicKvAddParam) {
        var ret = sysDicKvService.add(sysDicKvAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "sysDicKvAddParam", value = "系统字典kv信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody SysDicKvAddParam sysDicKvAddParam) {
        var ret = sysDicKvService.edit(sysDicKvAddParam);
        return ApiResult.fromTupleRet(ret);
    }
}
