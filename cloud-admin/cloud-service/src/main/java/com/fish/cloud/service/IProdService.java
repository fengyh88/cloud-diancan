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
 * @since 2020-03-07
 */
public interface IProdService extends IService<Prod> {

    /**
     * 根据商品类目查询列表
     * @param shopId
     * @param prodByCateParam
     * @return
     */
    List<ProdDto> listByCate(String shopId,ProdByCateParam prodByCateParam);
    /**
     * 详情
     *
     * @param id
     * @return
     */
    ProdDetailDto detail(String id);

    /**
     * 更改状态，上架下架删除
     * @param id
     * @param status
     * @return
     */
    TupleRet updateStatus(Long id, Integer status);

    /**
     * 增减库存，传正负数
     *
     * @param id
     * @return
     */
    TupleRet updateStock(Long id, Integer num);

    /**
     * 添加
     * @param shopId
     * @param empId
     * @param prodAddParam
     * @return
     */
    TupleRet add(String shopId, String empId, ProdAddParam prodAddParam);

    /**
     * 编辑
     * @param shopId
     * @param empId
     * @param prodEditParam
     * @return
     */
    TupleRet edit(String shopId, String empId, ProdEditParam prodEditParam);
}
