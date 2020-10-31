package com.fish.cloud.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.model.ShopImg;
import com.fish.cloud.repo.ShopImgMapper;
import com.fish.cloud.service.IShopImgService;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 店铺图
 * </p>
 *
 * @author fengyh
 * @since 2020-03-14
 */
@Service
public class ShopImgServiceImpl extends ServiceImpl<ShopImgMapper, ShopImg> implements IShopImgService {

    /**
     * 根据店铺Id查询列表
     * @param shopId
     * @return
     */
    @Override
    public List<ShopImg> listByShopId(String shopId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<ShopImg>()
        .eq(ShopImg::getLinkId,shopId));
        return models;
    }
}