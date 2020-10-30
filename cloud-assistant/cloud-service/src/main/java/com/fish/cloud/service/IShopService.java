package com.fish.cloud.service;

import com.fish.cloud.bean.model.Shop;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.ShopAddParam;
import com.fish.cloud.common.util.TupleRet;

/**
 * <p>
 * 店铺 服务类
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IShopService extends IService<Shop> {
    /**
     * 详情
     *
     * @param id
     * @return
     */
    public TupleRet detail(Long id);

    TupleRet updateStatus(Long id, Integer status);

    /**
     * 添加或者编辑
     *
     * @param shopAddParam
     * @return
     */
    public TupleRet addOrEdit(ShopAddParam shopAddParam);

    /**
     * 根据店铺唯一码获取店铺信息
     * @param code
     * @return
     */
    public Shop getByCode(String code);

    /**
     * 生成code，UUID，超管助手
     * @return
     */
    public TupleRet generateCode();
}
