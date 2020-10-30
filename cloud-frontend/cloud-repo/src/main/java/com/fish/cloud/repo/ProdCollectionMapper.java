package com.fish.cloud.repo;

import com.fish.cloud.bean.dto.ProdCollectionDto;
import com.fish.cloud.bean.model.ProdCollection;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 用户收藏
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface ProdCollectionMapper extends BaseMapper<ProdCollection> {
    /**
     * 全部
     * @param shopId
     * @param userId
     * @return
     */
    List<ProdCollectionDto> all(@Param("shopId") String shopId, @Param("userId") String userId);
}