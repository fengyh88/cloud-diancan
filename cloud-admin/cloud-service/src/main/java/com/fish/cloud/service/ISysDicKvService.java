package com.fish.cloud.service;

import com.fish.cloud.bean.model.SysDic;
import com.fish.cloud.bean.model.SysDicKv;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.SysDicKvAddParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 系统字典kv
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface ISysDicKvService extends IService<SysDicKv> {

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
     * @param sysDicKvAddParam
     * @return
     */
    TupleRet add(String shopId, SysDicKvAddParam sysDicKvAddParam);
    /**
     * 编辑
     *
     * @param sysDicKvAddParam
     * @return
     */
    TupleRet edit(String shopId, SysDicKvAddParam sysDicKvAddParam);


    /**
     * 根据系统字典编码获取列表
     * @param shopId
     * @param dicCode
     * @return
     */
    List<SysDicKv> listByDicCode(String shopId, String dicCode);
}
