package com.fish.cloud.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.model.ShopImg;

import java.util.List;

/**
 * <p>
 * 店铺图
 * </p>
 *
 * @author fengyh
 * @since 2020-03-14
 */
public interface IShopImgService extends IService<ShopImg> {
    /**
     * 根据店铺Id查询列表
     * @param shopId
     * @return
     */
	List<ShopImg> listByShopId(String shopId);
}
