package com.fish.cloud.api.controller;

import com.fish.cloud.bean.dto.ShopDto;
import com.fish.cloud.bean.param.ShopEditParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 店铺
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "店铺")
@Controller
@RequestMapping("/api/shop")
public class ShopController {
    @Autowired
    private IShopService shopService;

    @ApiOperation("详情")
    @GetMapping(value = "/detail")
    public ApiResult<ShopDto> detail() {
        var ret = shopService.detail();
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "shopEditParam", value = "店铺", required = true)
    @PostMapping(value = "/edit")
    public ApiResult edit(@RequestBody ShopEditParam shopEditParam) {
        var ret = shopService.edit(shopEditParam);
        return ApiResult.fromTupleRet(ret);
    }
}
