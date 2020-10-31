package com.fish.cloud.api.controller;

import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.bean.dto.ProdDetailDto;
import com.fish.cloud.bean.dto.ProdDto;
import com.fish.cloud.bean.param.ProdAddParam;
import com.fish.cloud.bean.param.ProdByCateParam;
import com.fish.cloud.bean.param.ProdEditParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IProdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.apache.commons.lang3.ArrayUtils;
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
@RequestMapping("/cloud/prod")
public class ProdController {
    @Autowired
    private IProdService prodService;

    @ApiOperation("根据商品类目查询列表")
    @ApiImplicitParam(name = "prodByCateParam", value = "根据商品类目查询信息", required = true)
    @PostMapping(value = "/listByCate")
    public ApiResult<List<ProdDto>> listByCate(@RequestBody ProdByCateParam prodByCateParam) {
        var dtos = prodService.listByCate(prodByCateParam);
        return ApiResult.success(dtos);
    }

    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "id", required = true)
    @GetMapping(value = "/detail/{id}")
    public ApiResult<ProdDetailDto> detail(@PathVariable(value = "id") Long id) {
        var dto = prodService.detail(id);
        return ApiResult.success(dto);
    }

    @ApiOperation("更改状态，上架下架删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
            @ApiImplicitParam(name = "status", value = "状态 -1删除 0禁用 1启用", required = true)
    })
    @GetMapping(value = "/updateStatus")
    public ApiResult updateStatus(@RequestParam(value = "id") Long id, @RequestParam("status") Integer status) {
        if (!ArrayUtils.contains(new int[]{-1, 0, 1}, status)) {
            return ApiResult.failed("status传值需为-1删除1上架或者0下架");
        }
        var ret = prodService.updateStatus(id, status);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "prodAddParam", value = "商品信息", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody ProdAddParam prodAddParam) {
        var ret = prodService.add(prodAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "prodEditParam", value = "商品信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody ProdEditParam prodEditParam) {
        var ret = prodService.edit(prodEditParam);
        return ApiResult.fromTupleRet(ret);
    }
}
