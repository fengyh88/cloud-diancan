package com.fish.cloud.service.impl;

import com.fish.cloud.bean.dto.ProdSkuDto;
import com.fish.cloud.bean.model.ProdSku;
import com.fish.cloud.repo.ProdSkuMapper;
import com.fish.cloud.service.IProdSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 单品SKU
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class ProdSkuServiceImpl extends ServiceImpl<ProdSkuMapper, ProdSku> implements IProdSkuService {

    @Override
    public List<ProdSkuDto> listByProdId(String prodId) {
        return baseMapper.listByProdId(prodId);
    }
}
