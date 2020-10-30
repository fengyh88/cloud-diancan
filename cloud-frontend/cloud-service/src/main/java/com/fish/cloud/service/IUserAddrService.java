package com.fish.cloud.service;

import com.fish.cloud.bean.model.UserAddr;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.UserAddrAddParam;
import com.fish.cloud.common.ret.TupleRet;

/**
 * <p>
 * 用户收货地址
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IUserAddrService extends IService<UserAddr> {

    /**
     * 设为默认收货地址
     *
     * @param id
     * @return
     */
    TupleRet updateDefault(String id, String userId);

    /**
     * 更新状态
     * @param id
     * @param status
     * @return
     */
    TupleRet updateStatus(Long id, Integer status);

    /**
     * 添加
     * @param userId
     * @param userAddrAddParam
     * @return
     */
    TupleRet add(String userId, UserAddrAddParam userAddrAddParam);
    /**
     * 编辑
     * @param userId
     * @param userAddrAddParam
     * @return
     */
    TupleRet edit(String userId, UserAddrAddParam userAddrAddParam);

    /**
     * 删除
     * @param addrId
     * @return
     */
    TupleRet delete(String addrId);
}
