package com.fish.cloud.repo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.model.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 订单 Mapper 接口
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface OrderMapper extends BaseMapper<Order> {
    List<Order> selectDtoPage(Page page, @Param("status") Integer status);
}