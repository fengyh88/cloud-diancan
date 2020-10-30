package com.fish.cloud.service;

import com.fish.cloud.bean.model.Dvy;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.common.ret.TupleRet;

/**
 * <p>
 * 送货方式
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IDvyService extends IService<Dvy> {
    /**
     * 详情
     *
     * @param shopId
     * @return
     */
    Dvy getByShopId(String shopId);
}
