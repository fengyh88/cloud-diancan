package com.fish.cloud.repo;

import com.fish.cloud.bean.model.UserAddr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 用户收货地址
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface UserAddrMapper extends BaseMapper<UserAddr> {
    void updateNotDefaultByUserId(@Param("userId") String userId);
}