package com.fish.cloud.service;

import com.fish.cloud.bean.dto.ProdFavoriteDto;
import com.fish.cloud.bean.model.ProdFavorite;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 用户喜欢
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IProdFavoriteService extends IService<ProdFavorite> {
    /**
     * 全部
     * @param shopId
     * @return
     */
    List<ProdFavoriteDto> all(String userId, String shopId);

    /**
     * 添加
     * @param userId
     * @param prodId
     * @param shopId
     */
    TupleRet add(String userId, String prodId, String shopId);

    /**
     * 删除
     */
    TupleRet delete(String favoriteId);
}
