package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.model.Call;
import com.fish.cloud.common.ret.TupleRet;

/**
 * <p>
 * 呼叫
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface ICallService extends IService<Call> {

    /**
     * 更新状态 (1呼叫 2已读 0过期)
     * @param id
     * @return
     */
    TupleRet read(Long id);

    /**
     * 更新状态 (1呼叫 2已读 0过期)
     * @param id
     * @return
     */
    TupleRet expire(Long id);
}
