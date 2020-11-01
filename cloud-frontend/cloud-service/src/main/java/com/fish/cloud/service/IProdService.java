package com.fish.cloud.service;

import com.fish.cloud.bean.dto.ProdDetailDto;
import com.fish.cloud.bean.dto.ProdDto;
import com.fish.cloud.bean.model.Prod;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.ProdByCateParam;

import java.util.List;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface IProdService extends IService<Prod> {
    /**
     * 根据商品类目查询列表
     * @param prodByCateParam
     * @return
     */
    List<ProdDto> listByCate(ProdByCateParam prodByCateParam);
    /**
     * 详情
     *
     * @param id
     * @return
     */
    ProdDetailDto detail(Long id);
}
