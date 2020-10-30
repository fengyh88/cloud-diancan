package com.fish.cloud.service;

import com.fish.cloud.bean.model.ProdCate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.ProdCateAddParam;
import com.fish.cloud.common.util.TupleRet;

import java.util.List;

/**
 * <p>
 * 商品类目 服务类
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IProdCateService extends IService<ProdCate> {
    Boolean updateStatus(Long id, Integer status);

    /**
     *
     * @param prodCateAddParam
     * @return
     */
    public TupleRet addOrEdit(ProdCateAddParam prodCateAddParam);
}
