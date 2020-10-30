package com.fish.cloud.repo;

import com.fish.cloud.bean.dto.EmpDto;
import com.fish.cloud.bean.model.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 员工
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface EmpMapper extends BaseMapper<Emp> {
    /**
     * 全部
     * @param shopId
     * @return
     */
    List<EmpDto> all(@Param("shopId") String shopId);

    /**
     * 详情
     * @param id
     * @return
     */
    EmpDto detail(@Param("id") Long id);
}