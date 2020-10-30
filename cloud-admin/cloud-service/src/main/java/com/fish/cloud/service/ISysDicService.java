package com.fish.cloud.service;

import com.fish.cloud.bean.model.SysDic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.SysDicAddParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 系统字典
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface ISysDicService extends IService<SysDic> {

    /**
     * 更新状态，正常禁用删除
     *
     * @param id
     * @return
     */
    TupleRet updateStatus(Long id, Integer status);

    /**
     * 添加
     *
     * @param sysDicAddParam
     * @return
     */
    TupleRet add(String shopId, SysDicAddParam sysDicAddParam);
    /**
     * 编辑
     *
     * @param sysDicAddParam
     * @return
     */
    TupleRet edit(String shopId, SysDicAddParam sysDicAddParam);


    /**
     * 所有列表
     *
     * @return
     */
    List<SysDic> all(String shopId);
}
