package com.fish.cloud.api.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.ProdCateDto;
import com.fish.cloud.bean.model.ProdCate;
import com.fish.cloud.bean.param.ProdCateAddParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IProdCateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品类目
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "商品类目")
@RestController
@RequestMapping("/prod/cate")
public class ProdCateController {
    @Autowired
    private IProdCateService prodCateService;

    /**
     * 列表
     *
     * @return
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    public ApiResult<List<ProdCateDto>> list() {
        var models = prodCateService.list(new LambdaQueryWrapper<ProdCate>()
                .eq(ProdCate::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(ProdCate::getStatus, 1));
        List<ProdCateDto> dtoList = models.stream().map(model -> {
            var dto = new ProdCateDto();
            BeanUtil.copyProperties(model, dto);
            return dto;
        }).collect(Collectors.toList());
        return ApiResult.success(dtoList);
    }

    @ApiOperation(value = "分页", notes = "分页")
    @GetMapping("/page")
    @ResponseBody
    public ApiResult<IPage<ProdCateDto>> page(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                            @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize) {
        IPage<ProdCate> modelPage = prodCateService.page(new Page<ProdCate>(pageNo, pageSize), new LambdaQueryWrapper<ProdCate>()
                .eq(ProdCate::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .ne(ProdCate::getStatus, -1));
        var dtoPage = modelPage.convert(model -> Convert.convert(ProdCateDto.class, model));
        return ApiResult.success(dtoPage);
    }

    @ApiOperation("更新状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
            @ApiImplicitParam(name = "status", value = "状态 -1删除 0禁用 1启用", required = true)
    })
    @GetMapping(value = "/status")
    public ApiResult status(@RequestParam("id") long id, @RequestParam("status") Integer status) {
        var ret = prodCateService.status(id, status);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "prodCateAddParam", value = "类目信息", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody ProdCateAddParam prodCateAddParam) {
        var ret = prodCateService.add(prodCateAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "prodCateAddParam", value = "类目信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody ProdCateAddParam prodCateAddParam) {
        var ret = prodCateService.edit(prodCateAddParam);
        return ApiResult.fromTupleRet(ret);
    }
}
