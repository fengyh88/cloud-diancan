package com.fish.cloud.api.controller;

import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.dto.ShopDto;
import com.fish.cloud.bean.param.ShopEditParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 店铺
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "店铺")
@RestController
@RequestMapping("/api/shop")
public class ShopController {
    @Autowired
    private IShopService shopService;

    @ApiOperation("详情")
    @GetMapping(value = "/detail")
    public ApiResult<ShopDto> detail() {
        var ret = shopService.detail(ApiContextHolder.getAuthDto().getShopId());
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "shopEditParam", value = "店铺信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult addOrEdit(@RequestBody ShopEditParam shopEditParam) {
        var ret = shopService.edit(ApiContextHolder.getAuthDto().getShopId(), shopEditParam);
        return ApiResult.fromTupleRet(ret);
    }
}
