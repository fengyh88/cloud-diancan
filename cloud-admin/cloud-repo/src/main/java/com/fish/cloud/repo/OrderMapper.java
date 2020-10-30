package com.fish.cloud.repo;

import com.fish.cloud.bean.dto.OrderCountStatusDto;
import com.fish.cloud.bean.dto.OrderDetailDto;
import com.fish.cloud.bean.dto.OrderDto;
import com.fish.cloud.bean.model.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fish.cloud.bean.param.OrderBySatusParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 订单
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 根据状态查询列表
     * @param shopId
     * @param orderBySatusParam
     * @return
     */
    List<OrderDto> listByStatus(@Param("shopId") String shopId, @Param("orderBySatusParam") OrderBySatusParam orderBySatusParam);

    /**
     * 详情
     * @param orderId
     * @return
     */
    OrderDetailDto detail(@Param("orderId") Long orderId);

    /**
     * 统计店铺订单数量
     * @param shopId
     * @return
     */
    OrderCountStatusDto countOrderStatus(@Param("shopId") String shopId);

}