package com.fish.cloud.service;

import com.fish.cloud.bean.dto.ProdCollectionDto;
import com.fish.cloud.bean.model.ProdCollection;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 用户收藏
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IProdCollectionService extends IService<ProdCollection> {
    /**
     * 全部
     * @param shopId
     * @return
     */
    List<ProdCollectionDto> all(String userId, String shopId);

    /**
     * 添加
     * @param userId
     * @param prodId
     * @param shopId
     */
    TupleRet add(String userId, String prodId, String shopId);

    /**
     * 删除
     * @param collectionId
     * @return
     */
    TupleRet delete(String collectionId);

    /**
     * 取消收藏
     * @param userId
     * @param prodId
     * @return
     */
    TupleRet cancel(String userId, String prodId);
}
