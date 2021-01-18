package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.dto.CallDto;
import com.fish.cloud.bean.model.Call;
import com.fish.cloud.bean.model.Table;
import com.fish.cloud.bean.param.CallAddParam;
import com.fish.cloud.bean.param.SysDicAddParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

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
     * 添加
     *
     * @param callAddParam
     * @return
     */
    TupleRet add(CallAddParam callAddParam);

    /**
     * 获取当前台桌列表
     * @return
     */
    List<Call> listByCurTable();
}
