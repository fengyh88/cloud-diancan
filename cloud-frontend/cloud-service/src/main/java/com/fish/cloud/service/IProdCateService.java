package com.fish.cloud.service;

import com.fish.cloud.bean.model.ProdCate;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品类目
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface IProdCateService extends IService<ProdCate> {

    /**
     * 所有列表
     *
     * @return
     */
    List<ProdCate> all();
}
