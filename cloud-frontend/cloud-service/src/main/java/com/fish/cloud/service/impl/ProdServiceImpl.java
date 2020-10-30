package com.fish.cloud.service.impl;

import com.fish.cloud.bean.dto.ProdAttrDto;
import com.fish.cloud.bean.dto.ProdDetailDto;
import com.fish.cloud.bean.dto.ProdDto;
import com.fish.cloud.bean.model.Prod;
import com.fish.cloud.bean.param.ProdParam;
import com.fish.cloud.common.util.JsonUtil;
import com.fish.cloud.repo.ProdMapper;
import com.fish.cloud.service.IProdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.service.IProdSkuService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class ProdServiceImpl extends ServiceImpl<ProdMapper, Prod> implements IProdService {

    @Autowired
    private IProdSkuService prodSkuService;

    @Override
    public List<ProdDto> all(String shopId, ProdParam prodParam) {
        var models = baseMapper.all(shopId, prodParam);
        return models;
    }

    @Override
    public ProdDetailDto detail(String id) {
        var model = baseMapper.detail(id);
        // 赋值skuList
        var skuList = prodSkuService.listByProdId(id);
        model.setSkuList(skuList);
        // 赋值attrList
        List<ProdAttrDto> prodAttrDtoList = JsonUtil.jsonToList(model.getAttr(),ProdAttrDto.class);
        model.setAttrList(prodAttrDtoList);
        return model;
    }
}
