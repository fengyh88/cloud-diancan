package com.fish.cloud.api.controller;

import cn.hutool.core.util.ObjectUtil;
import com.fish.cloud.bean.dto.ProdSkuDto;
import com.fish.cloud.bean.model.ProdImg;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.common.util.ImgUrlUtil;
import com.fish.cloud.service.IProdImgService;
import com.fish.cloud.service.IProdSkuService;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.BeanUtils;
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
 * 单品SKU
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Controller
@RequestMapping("/prodSku")
public class ProdSkuController {

    @Autowired
    private IProdSkuService prodSkuService;

    /**
     * 根据商品Id获取列表
     * @param prodId
     * @return
     */
    @ApiOperation(value = "根据商品Id获取列表", notes = "根据商品Id获取列表")
    @GetMapping("/listByProdId")
    @ResponseBody
    public ApiResult<List<ProdSkuDto>> listByProdId(@RequestParam Long prodId) {
        var models = prodSkuService.listByProdId(prodId);
        List<ProdSkuDto> dtoList = models.stream().map(model -> {
            ProdSkuDto prodSkuDto = new ProdSkuDto();
            BeanUtils.copyProperties(model, prodSkuDto);
            prodSkuDto.setImg(ImgUrlUtil.getFullPathImgUrl(prodSkuDto.getImg()));
            return prodSkuDto;
        }).collect(Collectors.toList());
        return ApiResult.success(dtoList);
    }
}
