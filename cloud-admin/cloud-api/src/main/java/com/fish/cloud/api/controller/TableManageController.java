package com.fish.cloud.api.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.model.Table;
import com.fish.cloud.bean.param.TableAddParam;
import com.fish.cloud.bean.param.TableEditParam;
import com.fish.cloud.bean.param.TableParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ITableManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 台桌管理
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "台桌管理")
@Controller
@RequestMapping("/api/table/manage")
public class TableManageController {
    @Autowired
    private ITableManageService tableManageService;

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
    public ApiResult<IPage<Table>> page(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                         @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize,
                                         TableParam tableParam) {
        // 分页
        IPage<Table> models = tableManageService.page(new Page<Table>(pageNo, pageSize), new LambdaQueryWrapper<Table>()
                .eq(Table::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .and(wrapper -> wrapper.like(StrUtil.isNotEmpty(tableParam.getKeywords()), Table::getTableCode, tableParam.getKeywords())
                        .or()
                        .like(StrUtil.isNotEmpty(tableParam.getKeywords()), Table::getTableName, tableParam.getKeywords())
                        .or()
                        .like(StrUtil.isNotEmpty(tableParam.getKeywords()), Table::getRemark, tableParam.getKeywords()))
                .ne(Table::getStatus, -1));
        return ApiResult.success(models);
    }

    @ApiOperation("更改状态，0为禁用 -1删除 1启用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "台桌Id", required = true),
            @ApiImplicitParam(name = "status", value = "状态 0为禁用 -1删除 1启用", required = true)
    })
    @GetMapping(value = "/status")
    public ApiResult status(@RequestParam("id") long id, @RequestParam("status") Integer status) {
        if (!ArrayUtils.contains(new int[]{-1, 0, 1}, status)) {
            return ApiResult.failed("需传入0为禁用 -1删除 1启用");
        }
        var ret = tableManageService.status(id, status);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "tableAddParam", value = "台桌", required = true)
    @PostMapping(value = "/add")
    public ApiResult add(@RequestBody TableAddParam tableAddParam) {
        var ret = tableManageService.add(tableAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "tableAddParam", value = "台桌", required = true)
    @PostMapping(value = "/edit")
    public ApiResult edit(@RequestBody TableEditParam tableEditParam) {
        var ret = tableManageService.edit(tableEditParam);
        return ApiResult.fromTupleRet(ret);
    }
}
