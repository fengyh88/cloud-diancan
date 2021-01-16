package com.fish.cloud.api.controller;

import cn.hutool.core.bean.BeanUtil;
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
@Controller
@RequestMapping("/prodCate")
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
        var models = prodCateService.all();
        List<ProdCateDto> dtoList = models.stream().map(model->{
            ProdCateDto dto = new ProdCateDto();
            BeanUtil.copyProperties(model,dto);
            return dto;
        }).collect(Collectors.toList());
        return ApiResult.success(dtoList);
    }
}
