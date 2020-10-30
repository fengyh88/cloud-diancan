package com.fish.cloud.repo;

import com.fish.cloud.bean.dto.ShopDto;
import com.fish.cloud.bean.model.Shop;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
  * 店铺
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface ShopMapper extends BaseMapper<Shop> {
    /**
     * 详情
     * @param id
     * @return
     */
    ShopDto detail(@Param("id") String id);
}