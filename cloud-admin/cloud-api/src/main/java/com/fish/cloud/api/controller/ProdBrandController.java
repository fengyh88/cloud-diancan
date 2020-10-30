package com.fish.cloud.api.controller;

import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.model.ProdBrand;
import com.fish.cloud.bean.param.ProdBrandAddParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IProdBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 品牌
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "品牌")
@RestController
@RequestMapping("/api/prodBrand")
public class ProdBrandController {
    @Autowired
    private IProdBrandService prodBrandService;

    @ApiOperation("所有列表")
    @GetMapping("/all")
    public ApiResult<List<ProdBrand>> all() {
        var dtos = prodBrandService.all(ApiContextHolder.getAuthDto().getShopId());
        return ApiResult.success(dtos);
    }

    @ApiOperation("更新状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
            @ApiImplicitParam(name = "status", value = "状态 -1删除 0禁用 1启用", required = true)
    })
    @GetMapping(value = "/updateStatus/{id}/{status}")
    public ApiResult updateStatus(@PathVariable("id") long id, @PathVariable("status") Integer status) {
        var ret = prodBrandService.updateStatus(id, status);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "prodBrandAddParam", value = "品牌信息", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody ProdBrandAddParam prodBrandAddParam) {
        var ret = prodBrandService.add(ApiContextHolder.getAuthDto().getShopId(), prodBrandAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "prodBrandAddParam", value = "品牌信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody ProdBrandAddParam prodBrandAddParam) {
        var ret = prodBrandService.edit(ApiContextHolder.getAuthDto().getShopId(), prodBrandAddParam);
        return ApiResult.fromTupleRet(ret);
    }
}
