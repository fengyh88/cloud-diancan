package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.model.ProdImg;

import java.util.List;

/**
 * <p>
 * 商品图
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface IProdImgService extends IService<ProdImg> {

    /**
     * 根据商品Id获取图片列表
     * @param prodId
     * @return
     */
    List<ProdImg> listByProdId(String prodId);
    /**
     * 根据单品SkuId获取图片列表
     * @param skuId
     * @return
     */
    List<ProdImg> listBySkuId(String skuId);
}
