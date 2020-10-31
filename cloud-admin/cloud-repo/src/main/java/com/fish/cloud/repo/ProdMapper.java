package com.fish.cloud.repo;

import com.fish.cloud.bean.dto.ProdDetailDto;
import com.fish.cloud.bean.dto.ProdDto;
import com.fish.cloud.bean.model.Prod;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fish.cloud.bean.param.ProdByCateParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 商品
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface ProdMapper extends BaseMapper<Prod> {
    /**
     * 根据商品类目查询列表
     * @param shopId
     * @param prodByCateParam
     * @return
     */
    List<ProdDto> listByCate(@Param("shopId") Long shopId, @Param("prodByCateParam") ProdByCateParam prodByCateParam);

    /**
     * 详情
     * @param id
     * @return
     */
    ProdDetailDto detail(@Param("id") Long id);
}