package com.fish.cloud.api.controller;

import com.fish.cloud.bean.dto.ProdCateDto;
import com.fish.cloud.bean.model.ProdCate;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IProdCateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 商品类目
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "商品类目")
@Controller
@RequestMapping("/api/prodCate")
public class ProdCateController {

    @Autowired
    private IProdCateService prodCateService;

    /**
     * 全部
     *
     * @return
     */
    @ApiOperation("所有列表")
    @GetMapping("/all")
    public ApiResult<List<ProdCateDto>> all() {
        var dtoList = prodCateService.all();
        return ApiResult.success(dtoList);
    }
}
