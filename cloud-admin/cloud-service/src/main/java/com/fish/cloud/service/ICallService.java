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
     * 更新状态，状态 -1删除 2已读
     * @param id
     * @param status
     * @return
     */
    TupleRet updateStatus(Long id, Integer status);
}
