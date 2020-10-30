package com.fish.cloud.service;

import com.fish.cloud.bean.dto.ProdFavoriteDto;
import com.fish.cloud.bean.dto.ProdSkuDto;
import com.fish.cloud.bean.model.ProdSku;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 单品SKU
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IProdSkuService extends IService<ProdSku> {
    /**
     * 根据prodId获取列表
     * @param prodId
     * @return
     */
    List<ProdSkuDto> listByProdId(String prodId);
}
