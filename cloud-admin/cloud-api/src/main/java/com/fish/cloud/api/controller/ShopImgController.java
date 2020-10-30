package com.fish.cloud.api.controller;

import com.fish.cloud.bean.param.ShopImgAddParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IShopImgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 店铺图
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "店铺图")
@RestController
@RequestMapping("/api/shopImg")
public class ShopImgController {
    @Autowired
    private IShopImgService shopImgService;

    @ApiOperation("删除")
    @ApiImplicitParam(name = "id", value = "id", required = true)
    @GetMapping(value = "/delete")
    public ApiResult delete(@RequestParam(name = "id") Long id) {
        var ret = shopImgService.delete(id);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("新增或编辑")
    @ApiImplicitParam(name = "shopImgAddParam", value = "店铺图信息", required = true)
    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    public ApiResult addOrEdit(@RequestBody ShopImgAddParam shopImgAddParam) {
        var ret = shopImgService.addOrEdit(shopImgAddParam);
        return ApiResult.fromTupleRet(ret);
    }
}
