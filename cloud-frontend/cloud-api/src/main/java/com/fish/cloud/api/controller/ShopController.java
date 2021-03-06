package com.fish.cloud.api.controller;

import com.fish.cloud.bean.dto.ShopDto;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private IShopService shopService;

    @ApiOperation("详情")
    @GetMapping(value = "/detail")
    public ApiResult<ShopDto> detail() {
        var ret = shopService.detail();
        return ApiResult.fromTupleRet(ret);
    }
}
