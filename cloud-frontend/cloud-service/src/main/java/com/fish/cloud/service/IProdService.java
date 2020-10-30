package com.fish.cloud.service;

import com.fish.cloud.bean.dto.ProdDetailDto;
import com.fish.cloud.bean.dto.ProdDto;
import com.fish.cloud.bean.model.Prod;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.ProdParam;

import java.util.List;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IProdService extends IService<Prod> {
    /**
     * 全部
     * @param shopId
     * @param prodParam
     * @return
     */
    List<ProdDto> all(String shopId, ProdParam prodParam);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    ProdDetailDto detail(String id);
}
