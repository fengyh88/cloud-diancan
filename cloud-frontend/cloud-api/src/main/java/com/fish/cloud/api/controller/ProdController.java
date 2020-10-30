package com.fish.cloud.api.controller;

import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.dto.ProdDetailDto;
import com.fish.cloud.bean.dto.ProdDto;
import com.fish.cloud.bean.param.ProdParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IProdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "商品")
@RestController
@RequestMapping("/prod")
public class ProdController {
    @Autowired
    private IProdService prodService;

    @ApiOperation("全部")
    @ApiImplicitParam(name = "prodParam", value = "全部商品查询信息", required = true)
    @PostMapping("/all")
    public ApiResult<List<ProdDto>> all(@RequestBody ProdParam prodParam) {
        var dtos = prodService.all(ApiContextHolder.getShopId(),prodParam);
        return ApiResult.success(dtos);
    }

    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "id", required = true)
    @GetMapping(value = "/detail")
    public ApiResult<ProdDetailDto> detail(@RequestParam String id) {
        var dto = prodService.detail(id);
        return ApiResult.success(dto);
    }
}
