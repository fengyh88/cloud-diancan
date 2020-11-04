package com.fish.cloud.service;

import com.fish.cloud.bean.model.ProdProp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.ProdPropAddParam;
import com.fish.cloud.bean.param.ProdPropEditParam;
import com.fish.cloud.common.ret.TupleRet;

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

    /**
     * 根据商品Id获取文本
     * @param prodId
     * @return
     */
    String getProdPropTextByProdId(Long prodId);

    /**
     * 更改状态，上架下架删除
     * @param id
     * @param status
     * @return
     */
    TupleRet updateStatus(Long id, Integer status);

    /**
     * 添加
     * @param prodPropAddParam
     * @return
     */
    TupleRet add(ProdPropAddParam prodPropAddParam);

    /**
     * 编辑
     * @param prodPropEditParam
     * @return
     */
    TupleRet edit(ProdPropEditParam prodPropEditParam);
}
