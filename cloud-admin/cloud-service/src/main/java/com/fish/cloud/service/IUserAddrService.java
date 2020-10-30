package com.fish.cloud.service;

import com.fish.cloud.bean.model.UserAddr;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.AddrAddParam;
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
    public TupleRet add(AddrAddParam addrAddParam);

    Boolean updateStatus(Long id, Integer status);

    public TupleRet setDefault(long id);
}
