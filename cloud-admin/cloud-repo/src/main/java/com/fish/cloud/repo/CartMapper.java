package com.fish.cloud.repo;

import com.fish.cloud.bean.dto.CartDto;
import com.fish.cloud.bean.model.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 购物车
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface CartMapper extends BaseMapper<Cart> {
    /**
     * 全部
     * @param shopId
     * @param userId
     * @return
     */
    List<CartDto> all(@Param("shopId") String shopId, @Param("userId") String userId);
}