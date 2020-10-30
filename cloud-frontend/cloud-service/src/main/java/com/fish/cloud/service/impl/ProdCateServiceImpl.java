package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.ProdCate;
import com.fish.cloud.repo.ProdCateMapper;
import com.fish.cloud.service.IProdCateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品类目
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class ProdCateServiceImpl extends ServiceImpl<ProdCateMapper, ProdCate> implements IProdCateService {

    /**
     * 全部
     * @param shopId
     * @return
     */
    @Override
    public List<ProdCate> all(String shopId) {
        return baseMapper.selectList(new LambdaQueryWrapper<ProdCate>()
                .eq(ProdCate::getShopId, shopId)
                .eq(ProdCate::getPId, 0)
                .eq(ProdCate::getStatus, 1)
                .orderByAsc(ProdCate::getSeq));
    }
}
