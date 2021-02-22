package com.fish.cloud.api.controller;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.ShopDto;
import com.fish.cloud.bean.model.Shop;
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
 * @since 2020-10-30
 */
@Api(tags = "店铺")
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private IShopService shopService;

    @ApiOperation(value = "分页", notes = "分页")
    @GetMapping("/page")
    @ResponseBody
    public ApiResult<IPage<ShopDto>> page(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                          @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize) {
        IPage<Shop> modelPage = shopService.page(new Page<Shop>(pageNo, pageSize), new LambdaQueryWrapper<Shop>().ne(Shop::getStatus, -1));
        IPage<ShopDto> dtoPage = modelPage.convert(model -> Convert.convert(ShopDto.class, model));
        return ApiResult.success(dtoPage);
    }

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
