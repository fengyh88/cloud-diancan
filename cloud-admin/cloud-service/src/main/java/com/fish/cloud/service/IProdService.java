package com.fish.cloud.service;

import com.fish.cloud.bean.model.Prod;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.ProdAddParam;
import com.fish.cloud.bean.param.ProdEditParam;
import com.fish.cloud.common.ret.TupleRet;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface IProdService extends IService<Prod> {

    /**
     * 更改状态，上架下架删除
     * @param id
     * @param status
     * @return
     */
    TupleRet updateStatus(Long id, Integer status);

    /**
     * 添加
     * @param prodAddParam
     * @return
     */
    TupleRet add(ProdAddParam prodAddParam);

    /**
     * 编辑
     * @param prodEditParam
     * @return
     */
    TupleRet edit(ProdEditParam prodEditParam);
}
