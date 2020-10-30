package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.Dvy;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.repo.DvyMapper;
import com.fish.cloud.service.IDvyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 送货方式
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class DvyServiceImpl extends ServiceImpl<DvyMapper, Dvy> implements IDvyService {

    @Override
    public Dvy getByShopId(String shopId) {
        var model = baseMapper.selectOne(new LambdaQueryWrapper<Dvy>()
                .eq(Dvy::getShopId, shopId)
                .eq(Dvy::getStatus, 1));
        return model;
    }
}
