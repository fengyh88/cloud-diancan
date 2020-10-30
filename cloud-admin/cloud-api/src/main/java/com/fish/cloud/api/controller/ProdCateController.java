package com.fish.cloud.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.api.context.ApiResponseUtil;
import com.fish.cloud.bean.model.ProdCate;
import com.fish.cloud.bean.param.ProdCateAddParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IProdCateService;
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
 * 商品类目
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "商品类目")
@RestController
@RequestMapping("/api/prodCate")
public class ProdCateController {
    @Autowired
    private IProdCateService prodCateService;

    /**
     * 全部
     *
     * @return
     */
    @ApiOperation("所有列表")
    @GetMapping("/all")
    public ApiResult<List<ProdCate>> all() {
        var dtos = prodCateService.all(ApiContextHolder.getAuthDto().getShopId());
        return ApiResult.success(dtos);
    }

    @ApiOperation("更新状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
            @ApiImplicitParam(name = "status", value = "状态 -1删除 0禁用 1启用", required = true)
    })
    @GetMapping(value = "/updateStatus/{id}/{status}")
    public ApiResult updateStatus(@PathVariable("id") long id, @PathVariable("status") Integer status) {
        var ret = prodCateService.updateStatus(id, status);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "prodCateAddParam", value = "类目信息", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody ProdCateAddParam prodCateAddParam) {
        var ret = prodCateService.add(ApiContextHolder.getAuthDto().getShopId(), prodCateAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "prodCateAddParam", value = "类目信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody ProdCateAddParam prodCateAddParam) {
        var ret = prodCateService.edit(ApiContextHolder.getAuthDto().getShopId(), prodCateAddParam);
        return ApiResult.fromTupleRet(ret);
    }
}
