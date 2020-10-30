package com.fish.cloud.repo;

import com.fish.cloud.bean.dto.ProdSkuDto;
import com.fish.cloud.bean.model.ProdSku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 单品SKU
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface ProdSkuMapper extends BaseMapper<ProdSku> {
    /**
     * 根据prodId获取列表
     * @param prodId
     * @return
     */
    List<ProdSkuDto> listByProdId(@Param("prodId") String prodId);
}