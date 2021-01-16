package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.model.Table;
import com.fish.cloud.common.ret.TupleRet;

/**
 * <p>
 * 台桌
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface ITableService extends IService<Table> {
    /**
     * 根据编码获取信息
     * @param tableCode
     * @return
     */
    Table getByTableCode(String tableCode);

    /**
     * 更新状态，1正常（空桌） 11 就餐
     *
     * @param id
     * @return
     */
    TupleRet updateStatus(Long id, Integer status);
}
