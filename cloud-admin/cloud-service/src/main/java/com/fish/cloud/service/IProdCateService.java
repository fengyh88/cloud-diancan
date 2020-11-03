package com.fish.cloud.service;

import com.fish.cloud.bean.model.ProdCate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.ProdCateAddParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 商品类目
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface IProdCateService extends IService<ProdCate> {

    /**
     *更新状态
     * @param id
     * @param status
     * @return
     */
    TupleRet updateStatus(Long id, Integer status);

    /**
     * 添加
     * @param prodCateAddParam
     * @return
     */
    TupleRet add(ProdCateAddParam prodCateAddParam);

    /**
     * 编辑
     * @param prodCateAddParam
     * @return
     */
    TupleRet edit(ProdCateAddParam prodCateAddParam);
}
