package com.fish.cloud.service;

import com.fish.cloud.bean.dto.ShopDto;
import com.fish.cloud.bean.model.Shop;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.common.ret.TupleRet;

/**
 * <p>
 * 店铺
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IShopService extends IService<Shop> {
    /**
     * 详情
     *
     * @param id
     * @return
     */
    TupleRet<ShopDto> detail(String id);
}
