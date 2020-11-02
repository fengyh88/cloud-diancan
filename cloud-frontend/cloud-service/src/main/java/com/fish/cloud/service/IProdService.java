package com.fish.cloud.service;

import com.fish.cloud.bean.dto.ProdDetailDto;
import com.fish.cloud.bean.dto.ProdDto;
import com.fish.cloud.bean.model.Prod;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.ProdAddParam;
import com.fish.cloud.bean.param.ProdByCateParam;
import com.fish.cloud.bean.param.ProdEditParam;
import com.fish.cloud.common.ret.TupleRet;

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

    /**
     * 更改状态，上架下架删除
     * @param id
     * @param status
     * @return
     */
    TupleRet updateStatus(Long id, Integer status);

    /**
     * 添加
     * @param prodAddParam
     * @return
     */
    TupleRet add(ProdAddParam prodAddParam);

    /**
     * 编辑
     * @param prodEditParam
     * @return
     */
    TupleRet edit(ProdEditParam prodEditParam);
}
