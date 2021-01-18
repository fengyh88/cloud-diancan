package com.fish.cloud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fish.cloud.bean.dto.ProdDto;
import com.fish.cloud.bean.model.ProdSku;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.*;
import com.fish.cloud.common.ret.TupleRet;

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
	/**
	 * 根据商品Id获取列表
	 * @param prodId
	 * @return
	 */
	List<ProdSku> listByProdId(Long prodId);

	/**
	 * 根据商品Id获取展示文本
	 * @param prodId
	 * @return
	 */
	String getProdSkuTextByProdId(Long prodId);

	/**
	 * 更改状态，上架下架删除
	 * @param id
	 * @param status
	 * @return
	 */
	TupleRet status(Long id, Integer status);

	/**
	 * 添加
	 * @param prodSkuAddParam
	 * @return
	 */
	TupleRet add(ProdSkuAddParam prodSkuAddParam);

	/**
	 * 编辑
	 * @param prodSkuEditParam
	 * @return
	 */
	TupleRet edit(ProdSkuEditParam prodSkuEditParam);
}
