package com.fish.cloud.api.controller;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.dto.ProdFavoriteDto;
import com.fish.cloud.bean.model.ProdFavorite;
import com.fish.cloud.bean.model.UserAddr;
import com.fish.cloud.bean.param.UserAddrAddParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IProdFavoriteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户喜欢
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "用户喜欢")
@RestController
@RequestMapping("/prodFavorite")
public class ProdFavoriteController {
    @Autowired
    private IProdFavoriteService prodFavoriteService;

    @ApiOperation("全部")
    @GetMapping("/all")
    public ApiResult<List<ProdFavoriteDto>> all() {
        List<ProdFavoriteDto> dtos = prodFavoriteService.all(ApiContextHolder.getAuthDto().getUserId(),ApiContextHolder.getShopId());
        return ApiResult.success(dtos);
    }

    @ApiOperation("是否是喜欢的商品")
    @RequestMapping(value = "/getIsFavorite",method = RequestMethod.GET)
    public ApiResult<Integer> getIsFavorite(@RequestBody JSONObject obj) {
        String prodId = obj.getStr("prodId", "");
        if (StringUtils.isEmpty(prodId)){
            return ApiResult.failed("商品Id未传入");
        }
        var dto = prodFavoriteService.getOne(new LambdaQueryWrapper<ProdFavorite>()
                .eq(ProdFavorite::getUserId, ApiContextHolder.getAuthDto().getUserId())
                .eq(ProdFavorite::getProdId, prodId));
        if (ObjectUtils.isEmpty(dto)){
            return ApiResult.success(0);
        }
        else {
            return ApiResult.success(1);
        }
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "obj", value = "prodId", required = true)
    @PostMapping(value = "/add")
    public ApiResult add(@RequestBody JSONObject obj){
        String prodId = obj.getStr("prodId", "");
        if (StringUtils.isEmpty(prodId)){
            return ApiResult.failed("商品Id未传入");
        }
        var ret = prodFavoriteService.add(ApiContextHolder.getAuthDto().getUserId(), prodId, ApiContextHolder.getShopId());
        return ApiResult.fromTupleRet(ret);
    }


    @ApiOperation("删除")
    @ApiImplicitParam(name = "obj", value = "id", required = true)
    @PostMapping(value = "/delete")
    public ApiResult delete(@RequestBody JSONObject obj){
        String id = obj.getStr("id", "");
        if (StringUtils.isEmpty(id)){
            return ApiResult.failed("Id未传入");
        }
        var ret = prodFavoriteService.delete(id);
        return ApiResult.fromTupleRet(ret);
    }
}
