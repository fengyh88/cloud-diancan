package com.fish.cloud.repo;

import com.fish.cloud.bean.dto.ProdDetailDto;
import com.fish.cloud.bean.dto.ProdDto;
import com.fish.cloud.bean.model.Prod;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fish.cloud.bean.param.ProdParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 商品
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface ProdMapper extends BaseMapper<Prod> {
    /**
     * 全部
     * @param shopId
     * @param prodParam
     * @return
     */
    List<ProdDto> all(@Param("shopId") String shopId,@Param("prodParam") ProdParam prodParam);

    /**
     * 详情
     * @param id
     * @return
     */
    ProdDetailDto detail(@Param("id") String id);
}