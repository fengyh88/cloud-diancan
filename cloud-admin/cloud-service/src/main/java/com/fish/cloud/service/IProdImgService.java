package com.fish.cloud.service;

import com.fish.cloud.bean.model.ProdImg;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.ProdImgAddParam;
import com.fish.cloud.common.ret.TupleRet;

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
    List<ProdImg> listByProdId(Long prodId);

    /**
     * 根据商品Id获取商品主图
     * @param prodId
     * @return
     */
    ProdImg getMainImgByProdId(Long prodId);

    /**
     * 根据单品SkuId获取图片列表
     * @param skuId
     * @return
     */
    List<ProdImg> listBySkuId(Long skuId);

    /**
     * 根据单品SkuId获取主图
     * @param skuId
     * @return
     */
    ProdImg getMainImgBySkuId(Long skuId);
    /**
     * 添加或者编辑
     *
     * @param prodImgAddParam
     * @return
     */
    TupleRet addOrEdit(ProdImgAddParam prodImgAddParam);

    /**
     * 删除
     * @param id
     * @return
     */
    TupleRet delete(Long id);
}
