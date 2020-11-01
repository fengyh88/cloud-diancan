package com.fish.cloud.api.controller;

import com.fish.cloud.bean.dto.ProdDetailDto;
import com.fish.cloud.bean.dto.ProdDto;
import com.fish.cloud.bean.param.ProdByCateParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IProdService;
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
 * 商品
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "商品")
@Controller
@RequestMapping("/api/prod")
public class ProdController {
    @Autowired
    private IProdService prodService;

    @ApiOperation("根据商品类目查询列表")
    @ApiImplicitParam(name = "prodByCateParam", value = "根据商品类目查询信息", required = true)
    @PostMapping(value = "/listByCate")
    public ApiResult<List<ProdDto>> listByCate(@RequestBody ProdByCateParam prodByCateParam) {
        var dtoList = prodService.listByCate(prodByCateParam);
        return ApiResult.success(dtoList);
    }

    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "id", required = true)
    @GetMapping(value = "/detail/{id}")
    public ApiResult<ProdDetailDto> detail(@PathVariable(value = "id") Long id) {
        var dto = prodService.detail(id);
        return ApiResult.success(dto);
    }
}
