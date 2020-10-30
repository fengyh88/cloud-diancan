package com.fish.cloud.repo;

import com.fish.cloud.bean.dto.ProdFavoriteDto;
import com.fish.cloud.bean.model.ProdFavorite;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 用户喜欢
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface ProdFavoriteMapper extends BaseMapper<ProdFavorite> {
    /**
     * 全部
     * @param shopId
     * @param userId
     * @return
     */
    List<ProdFavoriteDto> all(@Param("shopId") String shopId, @Param("userId") String userId);
}