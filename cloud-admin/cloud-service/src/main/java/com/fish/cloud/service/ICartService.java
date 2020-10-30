package com.fish.cloud.service;

import com.fish.cloud.bean.model.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.CartAddParam;
import com.fish.cloud.bean.param.CartEditParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface ICartService extends IService<Cart> {
    public TupleRet<List<Cart>> all();

    public TupleRet<Integer> countGoods();

    public TupleRet add(CartAddParam cartAddParam);

    public TupleRet delete(Long id);

    public TupleRet batchDelete(List<Long> ids);

    public TupleRet edit(CartEditParam cartEditParam);

}
