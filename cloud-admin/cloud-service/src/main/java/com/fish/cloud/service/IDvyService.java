package com.fish.cloud.service;

import com.fish.cloud.bean.model.Dvy;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.DvyAddParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 送货方式
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IDvyService extends IService<Dvy> {

    /**
     * 更新状态，正常禁用删除。 注：一个店铺只有一个是启用的
     *
     * @param id
     * @return
     */
    TupleRet updateStatus(String shopId, Long id, Integer status);

    /**
     * 添加
     *
     * @param dvyAddParam
     * @return
     */
    TupleRet add(String shopId, DvyAddParam dvyAddParam);
    /**
     * 编辑
     *
     * @param dvyAddParam
     * @return
     */
    TupleRet edit(String shopId, DvyAddParam dvyAddParam);

    /**
     * 所有列表
     *
     * @return
     */
    List<Dvy> all(String shopId);
}
