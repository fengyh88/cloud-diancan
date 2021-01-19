package com.fish.cloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.fish.cloud.bean.model.Shop;
import com.fish.cloud.bean.param.ShopAddParam;
import com.fish.cloud.bean.param.ShopEditParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.ShopMapper;
import com.fish.cloud.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 店铺
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Override
    public TupleRet add(ShopAddParam shopAddParam) {
        var model = new Shop();
        BeanUtil.copyProperties(shopAddParam,model);
        try {
            baseMapper.insert(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success();
    }


    /**
     * 编辑
     * @param shopEditParam
     * @return
     */
    @Override
    public TupleRet edit(ShopEditParam shopEditParam) {
        var model = baseMapper.selectById(shopEditParam.getShopId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("未查询到店铺信息");
        }
        BeanUtil.copyProperties(shopEditParam,model);
        model.setUpdateTime(DateTimeUtil.getCurrentDateTime());

        try {
            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success();
    }

}
