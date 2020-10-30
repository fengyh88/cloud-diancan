package com.fish.cloud.repo;

import com.fish.cloud.bean.dto.UserDto;
import com.fish.cloud.bean.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
  * 用户
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 详情
     * @param id
     * @return
     */
    UserDto detail(@Param("id") String id);
}