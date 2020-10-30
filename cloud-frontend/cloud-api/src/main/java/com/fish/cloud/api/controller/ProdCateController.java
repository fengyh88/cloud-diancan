package com.fish.cloud.api.controller;

import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.model.ProdCate;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.common.token.AuthDto;
import com.fish.cloud.service.IProdCateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 商品类目
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "商品类目")
@RestController
@RequestMapping("/prodCate")
public class ProdCateController {
    @Autowired
    private IProdCateService prodCateService;

    @ApiOperation("全部")
    @GetMapping("/all")
    public ApiResult<List<ProdCate>> all() {
        List<ProdCate> models = prodCateService.all(ApiContextHolder.getShopId());
        return ApiResult.success(models);
    }
}
