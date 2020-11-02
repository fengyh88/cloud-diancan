package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.model.ProdImg;
import com.fish.cloud.repo.ProdImgMapper;
import com.fish.cloud.service.IProdImgService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品图
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class ProdImgServiceImpl extends ServiceImpl<ProdImgMapper, ProdImg> implements IProdImgService {

    /**
     * 根据商品Id获取商品图片列表
     * @param prodId
     * @return
     */
    @Override
    public List<ProdImg> listByProdId(String prodId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<ProdImg>()
                .eq(ProdImg::getImgType, 1)
                .eq(ProdImg::getLinkId, prodId));
        return models;
    }

    @Override
    public List<ProdImg> listBySkuId(String skuId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<ProdImg>()
                .eq(ProdImg::getImgType, 2)
                .eq(ProdImg::getLinkId, skuId));
        return models;
    }
}
