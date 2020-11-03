package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.ProdProp;
import com.fish.cloud.repo.ProdPropMapper;
import com.fish.cloud.service.IProdPropService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品属性
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class ProdPropServiceImpl extends ServiceImpl<ProdPropMapper, ProdProp> implements IProdPropService {

    @Override
    public List<ProdProp> listByProdId(Long prodId) {
        return baseMapper.selectList(new LambdaQueryWrapper<ProdProp>()
                .eq(ProdProp::getPropId, prodId)
                .eq(ProdProp::getStatus, 1));
    }
}
