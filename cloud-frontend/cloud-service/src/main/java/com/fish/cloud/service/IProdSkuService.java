package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.model.ProdSku;

import java.util.List;

/**
 * <p>
 * 单品SKU
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface IProdSkuService extends IService<ProdSku> {
    /**
     * 根据商品Id获取列表
     * @param prodId
     * @return
     */
    List<ProdSku> listByProdId(Long prodId);
}
