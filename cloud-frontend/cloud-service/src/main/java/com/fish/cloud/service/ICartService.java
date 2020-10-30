package com.fish.cloud.service;

import com.fish.cloud.bean.dto.CartDto;
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
    /**
     * 全部
     * @param shopId
     * @param userId
     * @return
     */
    List<CartDto> all(String shopId, String userId);

    /**
     * 根据Ids获取列表
     * @param cartIds
     * @return
     */
    List<CartDto> listByCartIds(List<String> cartIds);
    /**
     * 统计购物车中商品数量
     * @param shopId
     * @param userId
     * @return
     */
    Integer countProd(String shopId, String userId);

    /**
     * 添加
     * @param shopId
     * @param userId
     * @param cartAddParam
     * @return
     */
    TupleRet<String> add(String shopId, String userId, CartAddParam cartAddParam);

    /**
     * 删除
     * @param id
     * @return
     */
    TupleRet delete(String id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    TupleRet batchDelete(List<Long> ids);
    /**
     * 清空
     * @return
     */
    TupleRet clear(String shopId, String userId);

    /**
     * 编辑
     * @param cartEditParam
     * @return
     */
    TupleRet edit(CartEditParam cartEditParam);

    /**
     * 清空某个用户购物车数据
     * @param userId
     * @param shopId
     * @return
     */
    TupleRet clearByUserIdAndShopId(String userId, String shopId);
}
