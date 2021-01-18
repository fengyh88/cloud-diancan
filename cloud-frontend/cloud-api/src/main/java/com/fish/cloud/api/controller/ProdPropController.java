package com.fish.cloud.api.controller;

import cn.hutool.core.bean.BeanUtil;
import com.fish.cloud.bean.dto.ProdPropDto;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.common.util.StrUtil;
import com.fish.cloud.service.IProdPropService;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品属性
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Controller
@RequestMapping("/prodProp")
public class ProdPropController {

    @Autowired
    private IProdPropService prodPropService;

    /**
     * 根据商品Id获取列表
     *
     * @param prodId
     * @return
     */
    @ApiOperation(value = "根据商品Id获取列表", notes = "根据商品Id获取列表")
    @GetMapping("/listByProdId")
    @ResponseBody
    public ApiResult<List<ProdPropDto>> listByProdId(@RequestParam Long prodId) {
        var models = prodPropService.listByProdId(prodId);
        List<ProdPropDto> dtoList = models.stream().map(model -> {
            ProdPropDto dto = new ProdPropDto();
            BeanUtil.copyProperties(model, dto);
            dto.setPropValueList(StrUtil.splitToList(dto.getPropValue(), ","));
            return dto;
        }).collect(Collectors.toList());
        return ApiResult.success(dtoList);
    }
}
