package com.fish.cloud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fish.cloud.bean.dto.ProdDto;
import com.fish.cloud.bean.model.Prod;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.ProdAddParam;
import com.fish.cloud.bean.param.ProdByCateParam;
import com.fish.cloud.bean.param.ProdEditParam;
import com.fish.cloud.common.ret.TupleRet;
import org.springframework.web.bind.annotation.RequestParam;

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
     * 根据商品类目分页
     * @param pageNo
     * @param pageSize
     * @param prodByCateParam
     * @return
     */
    IPage<ProdDto> pageByCate(Integer pageNo, Integer pageSize, ProdByCateParam prodByCateParam);

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
