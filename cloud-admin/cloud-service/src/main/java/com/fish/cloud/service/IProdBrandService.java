package com.fish.cloud.service;

import com.fish.cloud.bean.model.ProdBrand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.ProdBrandAddParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 品牌
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IProdBrandService extends IService<ProdBrand> {

    /**
     * 所有列表
     *
     * @return
     */
    List<ProdBrand> all(String shopId);

    /**
     *更新状态
     * @param id
     * @param status
     * @return
     */
    TupleRet updateStatus(Long id, Integer status);

    /**
     * 添加
     * @param shopId
     * @param prodBrandAddParam
     * @return
     */
    TupleRet add(String shopId, ProdBrandAddParam prodBrandAddParam);

    /**
     * 编辑
     * @param shopId
     * @param prodBrandAddParam
     * @return
     */
    TupleRet edit(String shopId, ProdBrandAddParam prodBrandAddParam);
}
