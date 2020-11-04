package com.fish.cloud.api.controller;

import com.fish.cloud.bean.model.ProdProp;
import com.fish.cloud.bean.param.ProdPropAddParam;
import com.fish.cloud.bean.param.ProdPropEditParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IProdPropService;
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
 * 商品属性
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "商品属性")
@Controller
@RequestMapping("/api/prodProp")
public class ProdPropController {
    @Autowired
    private IProdPropService prodPropService;

    /**
     * 根据商品Id获取列表
     * @param prodId
     * @return
     */
    @ApiOperation(value = "根据商品Id获取列表", notes = "根据商品Id获取列表")
    @GetMapping("/listByProdId")
    @ResponseBody
    public ApiResult<List<ProdProp>> listByProdId(@RequestParam Long prodId) {
        var dtoList = prodPropService.listByProdId(prodId);
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
        var ret = prodPropService.updateStatus(id, status);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "prodPropAddParam", value = "商品属性", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody ProdPropAddParam prodPropAddParam) {
        var ret = prodPropService.add(prodPropAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "prodPropEditParam", value = "商品属性", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody ProdPropEditParam prodPropEditParam) {
        var ret = prodPropService.edit(prodPropEditParam);
        return ApiResult.fromTupleRet(ret);
    }
}
