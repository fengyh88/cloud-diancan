package com.fish.cloud.repo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fish.cloud.bean.dto.OrderCountStatusDto;
import com.fish.cloud.bean.model.Order;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
  * 订单
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 统计店铺订单数量
     * @param shopId
     * @return
     */
    OrderCountStatusDto countOrderStatus(@Param("shopId") Long shopId);
}