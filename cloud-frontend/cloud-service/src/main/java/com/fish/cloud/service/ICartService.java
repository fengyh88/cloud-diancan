package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.dto.CartDto;
import com.fish.cloud.bean.model.Cart;
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
 * @since 2020-10-30
 */
public interface ICartService extends IService<Cart> {
    /**
     * 全部
     * @return
     */
    List<CartDto> all();

    /**
     * 根据Ids获取列表
     * @param cartIds
     * @return
     */
    List<CartDto> listByCartIds(List<Long> cartIds);
    /**
     * 统计购物车中商品数量
     * @return
     */
    Integer countProd();

    /**
     * 添加
     * @param cartAddParam
     * @return
     */
    TupleRet<String> add(CartAddParam cartAddParam);

    /**
     * 删除
     * @param id
     * @return
     */
    TupleRet delete(Long id);

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
    TupleRet clear();

    /**
     * 编辑
     * @param cartEditParam
     * @return
     */
    TupleRet edit(CartEditParam cartEditParam);

    /**
     * 清空某个台桌购物车数据
     * @param tableId
     * @param shopId
     * @return
     */
    TupleRet clearByShopIdAndTableId(Long tableId, Long shopId);
}
