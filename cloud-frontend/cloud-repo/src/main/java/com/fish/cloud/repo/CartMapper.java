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
 * @since 2020-10-30
 */
public interface CartMapper extends BaseMapper<Cart> {
    /**
     * 全部
     * @param shopId
     * @param userId
     * @return
     */
    List<CartDto> all(@Param("shopId") Long shopId, @Param("userId") String userId);

    /**
     * 根据Ids获取列表
     * @param cartIds
     * @return
     */
    List<CartDto> listByCartIds(@Param("cartIds") List<Long> cartIds);
}