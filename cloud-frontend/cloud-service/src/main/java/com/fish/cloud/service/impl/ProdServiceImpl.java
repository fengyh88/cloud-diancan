package com.fish.cloud.service.impl;

import com.fish.cloud.bean.dto.ProdDetailDto;
import com.fish.cloud.bean.dto.ProdDto;
import com.fish.cloud.bean.model.Prod;
import com.fish.cloud.bean.param.ProdByCateParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.repo.ProdMapper;
import com.fish.cloud.service.IProdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class ProdServiceImpl extends ServiceImpl<ProdMapper, Prod> implements IProdService {
    @Override
    public List<ProdDto> listByCate(ProdByCateParam prodByCateParam) {
        var models = baseMapper.listByCate(ApiContextHolder.getShopId(), prodByCateParam);
        return models;
    }

    @Override
    public ProdDetailDto detail(Long id) {
        var model = baseMapper.detail(id);
        return model;
    }
}
