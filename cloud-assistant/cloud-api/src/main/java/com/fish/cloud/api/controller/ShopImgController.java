package com.fish.cloud.api.controller;

import com.fish.cloud.bean.dto.ShopImgDto;
import com.fish.cloud.bean.param.ShopImgAddParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IShopImgService;
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
 * 店铺图
 * </p>
 *
 * @author fengyh
 * @since 2020-10-31
 */
@Api(tags = "店铺图")
@Controller
@RequestMapping("/shop/img")
public class ShopImgController {

    @Autowired
    private IShopImgService shopImgService;

    /**
     * 根据店铺Id查询列表
     * @param shopId
     * @return
     */
    @ApiOperation(value = "根据店铺Id查询列表", notes = "根据店铺Id查询列表")
    @GetMapping("/listByShopId")
    @ResponseBody
    public ApiResult<List<ShopImgDto>> listByShopId(@RequestParam Long shopId) {
        var dtoList = shopImgService.listByShopId(shopId);
        return ApiResult.success(dtoList);
    }

    @ApiOperation("删除")
    @ApiImplicitParam(name = "id", value = "id", required = true)
    @GetMapping(value = "/delete")
    public ApiResult delete(@RequestParam(name = "id") Long id) {
        var ret = shopImgService.delete(id);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("新增编辑")
    @ApiImplicitParam(name = "shopImgAddParam", value = "店铺图信息", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody ShopImgAddParam shopImgAddParam) {
        var ret = shopImgService.add(shopImgAddParam);
        return ApiResult.fromTupleRet(ret);
    }
}
