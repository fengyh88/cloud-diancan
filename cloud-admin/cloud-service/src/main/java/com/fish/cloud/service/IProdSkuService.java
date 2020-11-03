package com.fish.cloud.service;

import com.fish.cloud.bean.model.ProdSku;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 单品SKU
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface IProdSkuService extends IService<ProdSku> {
	List<ProdSku> listByProdId(Long prodId);
}
