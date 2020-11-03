package com.fish.cloud.service;

import com.fish.cloud.bean.model.ProdProp;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品属性
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface IProdPropService extends IService<ProdProp> {
    /**
     * 根据商品Id获取
     * @param prodId
     * @return
     */
	List<ProdProp> listByProdId(Long prodId);
}
