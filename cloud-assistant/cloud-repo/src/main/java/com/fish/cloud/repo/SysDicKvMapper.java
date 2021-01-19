package com.fish.cloud.repo;

import com.fish.cloud.bean.model.SysDicKv;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
  * 系统字典kv
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface SysDicKvMapper extends BaseMapper<SysDicKv> {
    String getTextTextByDicCodeAndKey(@Param("dicCode") String dicCode, @Param("key") String key);

    String getTextByTableAndCodeAndKey(@Param("table") String table, @Param("text") String text, @Param("code") String code, @Param("key") String key);
}