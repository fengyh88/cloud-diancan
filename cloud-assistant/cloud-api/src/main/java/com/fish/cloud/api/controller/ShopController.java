package com.fish.cloud.api.controller;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.ShopDto;
import com.fish.cloud.bean.model.Shop;
import com.fish.cloud.bean.param.ShopAddParam;
import com.fish.cloud.bean.param.ShopEditParam;
import com.fish.cloud.bean.param.ShopStorageParam;
import com.fish.cloud.common.context.ApiContextHolder;
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
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private IShopService shopService;

    /**
     * 分页
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页", notes = "分页")
    @GetMapping("/page")
    @ResponseBody
    public ApiResult<IPage<ShopDto>> page(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                          @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize) {
        IPage<Shop> modelPage = shopService.page(new Page<Shop>(pageNo, pageSize), new LambdaQueryWrapper<Shop>().ne(Shop::getStatus, -1));
        IPage<ShopDto> dtoPage = modelPage.convert(model -> Convert.convert(ShopDto.class, model));
        return ApiResult.success(dtoPage);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "shopAddParam", value = "添加", required = true)
    @PostMapping(value = "/add")
    public ApiResult add(@RequestBody ShopAddParam shopAddParam) {
        var ret = shopService.add(shopAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "shopEditParam", value = "店铺", required = true)
    @PostMapping(value = "/edit")
    public ApiResult edit(@RequestBody ShopEditParam shopEditParam) {
        var ret = shopService.edit(shopEditParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("存储选择的店铺")
    @ApiImplicitParam(name = "shopStorageParam", value = "选择的店铺信息", required = true)
    @RequestMapping(value = "/storage", method = RequestMethod.POST)
    public ApiResult storage(@RequestBody ShopStorageParam shopStorageParam) {
        ApiContextHolder.getAuthDto().setShopId(shopStorageParam.getShopId());
        return ApiResult.success();
    }
}
