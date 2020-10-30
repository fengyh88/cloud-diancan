package com.fish.cloud.service;

import com.fish.cloud.bean.model.ProdImg;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.ProdImgAddParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 商品图
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IProdImgService extends IService<ProdImg> {
    /**
     * 添加或者编辑
     *
     * @param prodImgAddParam
     * @return
     */
    TupleRet addOrEdit(ProdImgAddParam prodImgAddParam);

    /**
     * 删除
     * @param id
     * @return
     */
    TupleRet delete(Long id);

    /**
     * 根据商品Id获取商品图片列表
     * @param prodId
     * @return
     */
    List<ProdImg> listByProdId(String prodId);
}
