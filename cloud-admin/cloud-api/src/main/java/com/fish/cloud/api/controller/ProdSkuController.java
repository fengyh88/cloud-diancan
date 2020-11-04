package com.fish.cloud.api.controller;

import com.fish.cloud.bean.model.ProdSku;
import com.fish.cloud.bean.param.*;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IProdSkuService;
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
 * 单品SKU
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "商品Sku")
@Controller
@RequestMapping("/api/prodSku")
public class ProdSkuController {
    @Autowired
    private IProdSkuService prodSkuService;

    /**
     * 根据商品Id获取列表
     * @param prodId
     * @return
     */
    @ApiOperation(value = "根据商品Id获取列表", notes = "根据商品Id获取列表")
    @GetMapping("/listByProdId")
    @ResponseBody
    public ApiResult<List<ProdSku>> listByProdId(@RequestParam Long prodId) {
        var dtoList = prodSkuService.listByProdId(prodId);
        return ApiResult.success(dtoList);
    }

    @ApiOperation("更改状态，上架下架删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
            @ApiImplicitParam(name = "status", value = "状态 -1删除", required = true)
    })
    @GetMapping(value = "/updateStatus")
    public ApiResult updateStatus(@RequestParam(value = "id") Long id, @RequestParam("status") Integer status) {
        if (!ArrayUtils.contains(new int[]{-1, 0, 1}, status)) {
            return ApiResult.failed("status传值需为-1删除 0禁用, 1启用");
        }
        var ret = prodSkuService.updateStatus(id, status);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "prodSkuAddParam", value = "商品单品", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody ProdSkuAddParam prodSkuAddParam) {
        var ret = prodSkuService.add(prodSkuAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "prodSkuEditParam", value = "商品单品", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody ProdSkuEditParam prodSkuEditParam) {
        var ret = prodSkuService.edit(prodSkuEditParam);
        return ApiResult.fromTupleRet(ret);
    }
}
