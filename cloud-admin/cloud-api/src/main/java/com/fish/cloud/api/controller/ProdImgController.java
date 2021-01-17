package com.fish.cloud.api.controller;

import com.fish.cloud.bean.model.ProdImg;
import com.fish.cloud.bean.param.ProdImgAddParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IProdImgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品图
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "商品图")
@Controller
@RequestMapping("/prodImg")
public class ProdImgController {
    @Autowired
    private IProdImgService prodImgService;

    /**
     * 根据商品Id获取列表
     * @param prodId
     * @return
     */
    @ApiOperation(value = "根据商品Id获取列表", notes = "根据商品Id获取列表")
    @GetMapping("/listByProdId")
    @ResponseBody
    public ApiResult<List<ProdImg>> listByProdId(@RequestParam Long prodId) {
        var dtoList = prodImgService.listByProdId(prodId);
        return ApiResult.success(dtoList);
    }

    @ApiOperation("删除")
    @ApiImplicitParam(name = "id", value = "id", required = true)
    @GetMapping(value = "/delete")
    public ApiResult delete(@RequestParam(name = "id") Long id) {
        var ret = prodImgService.delete(id);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("新增或编辑")
    @ApiImplicitParam(name = "prodImgAddParam", value = "商品图信息", required = true)
    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    public ApiResult addOrEdit(@RequestBody ProdImgAddParam prodImgAddParam) {
        var ret = prodImgService.addOrEdit(prodImgAddParam);
        return ApiResult.fromTupleRet(ret);
    }
}
