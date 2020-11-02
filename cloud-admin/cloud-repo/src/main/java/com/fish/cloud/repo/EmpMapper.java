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
 * @since 2020-10-30
 */
public interface EmpMapper extends BaseMapper<Emp> {
}