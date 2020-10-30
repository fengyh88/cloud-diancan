package com.fish.cloud.service;

import com.fish.cloud.bean.model.Prod;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.ProdAddParam;
import com.fish.cloud.common.util.TupleRet;

/**
 * <p>
 * 商品 服务类
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IProdService extends IService<Prod> {
    TupleRet updateStatus(Long id, Integer status);

    /**
     * 增减库存
     *
     * @param id
     * @return
     */
    public TupleRet updateStock(long id, Integer num);
    /**
     * 增加或修改
     * @param prodAddParam
     * @return
     */
    public TupleRet addOrEdit(ProdAddParam prodAddParam);
}
