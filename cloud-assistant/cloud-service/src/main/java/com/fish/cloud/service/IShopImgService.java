package com.fish.cloud.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.dto.ShopImgDto;
import com.fish.cloud.bean.model.ShopImg;
import com.fish.cloud.bean.param.ShopImgAddParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 店铺图
 * </p>
 *
 * @author fengyh
 * @since 2020-10-31
 */
public interface IShopImgService extends IService<ShopImg> {
    /**
     * 根据店铺Id查询列表
     * @param shopId
     * @return
     */
    List<ShopImgDto> listByShopId(Long shopId);

    /**
     * 添加或者编辑
     *
     * @param shopImgAddParam
     * @return
     */
    TupleRet addOrEdit(ShopImgAddParam shopImgAddParam);

    /**
     * 删除
     * @param id
     * @return
     */
    TupleRet delete(Long id);
}
