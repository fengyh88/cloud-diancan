package com.fish.cloud.api.controller;

import cn.hutool.json.JSONObject;
import com.fish.cloud.bean.dto.CartDto;
import com.fish.cloud.bean.param.CartAddParam;
import com.fish.cloud.bean.param.CartByCartIdsParam;
import com.fish.cloud.bean.param.CartEditParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ICartService;
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
 * 购物车
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "购物车")
@Controller
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    @ApiOperation("全部列表")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ApiResult<List<CartDto>> all() {
        var dtos = cartService.all();
        return ApiResult.success(dtos);
    }

    @ApiOperation("根据Ids获取列表")
    @RequestMapping(value = "/listByCartIds", method = RequestMethod.POST)
    public ApiResult<List<CartDto>> listByCartIds(@RequestBody CartByCartIdsParam cartByCartIdsParam) {
        var dtos = cartService.listByCartIds(cartByCartIdsParam.getCartIds());
        return ApiResult.success(dtos);
    }

    @ApiOperation("购物中商品数量")
    @GetMapping(value = "/countProd")
    public ApiResult<Integer> countProd() {
        var count = cartService.countProd();
        return ApiResult.success(count);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "cartAddParam", value = "购物车添加信息", required = true)
    @PostMapping(value = "/add")
    public ApiResult<String> add(@RequestBody CartAddParam cartAddParam) {
        var ret = cartService.add(cartAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "cartAddParam", value = "购物车编辑信息", required = true)
    @PostMapping(value = "/edit")
    public ApiResult edit(@RequestBody CartEditParam cartEditParam) {
        var ret = cartService.edit(cartEditParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("删除")
    @ApiImplicitParam(name = "obj", value = "obj", required = true)
    @PostMapping(value = "/delete")
    public ApiResult delete(@RequestBody JSONObject obj) {
        Long id = obj.getLong("id", 0L);
        var ret = cartService.delete(id);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "ids", value = "ids", required = true)
    @PostMapping(value = "/batchDelete")
    public ApiResult batchDelete(@RequestBody List<Long> ids) {
        var ret = cartService.batchDelete(ids);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("清空")
    @PostMapping(value = "/clear")
    public ApiResult clear() {
        var ret = cartService.clear();
        return ApiResult.fromTupleRet(ret);
    }
}
