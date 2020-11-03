package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
 * @since 2020-10-30
 */
@Service
public class ProdSkuServiceImpl extends ServiceImpl<ProdSkuMapper, ProdSku> implements IProdSkuService {

    @Override
    public List<ProdSku> listByProdId(Long prodId) {
        return baseMapper.selectList(new LambdaQueryWrapper<ProdSku>()
                .eq(ProdSku::getProdId, prodId)
                .eq(ProdSku::getStatus, 1));
    }
}
