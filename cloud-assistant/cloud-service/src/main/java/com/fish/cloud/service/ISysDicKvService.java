package com.fish.cloud.service;

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
 * @since 2020-10-30
 */
public interface ISysDicKvService extends IService<SysDicKv> {

    /**
     * 根据系统字典编码获取列表
     * @param dicCode
     * @return
     */
    List<SysDicKv> listByDicCode(String dicCode);

    /**
     * 更新状态，正常禁用删除
     *
     * @param id
     * @return
     */
    TupleRet status(Long id, Integer status);

    /**
     * 添加
     *
     * @param sysDicKvAddParam
     * @return
     */
    TupleRet add(SysDicKvAddParam sysDicKvAddParam);
    /**
     * 编辑
     *
     * @param sysDicKvAddParam
     * @return
     */
    TupleRet edit(SysDicKvAddParam sysDicKvAddParam);

    String getTextTextByDicCodeAndKey(String table, String text, String code, String key);

    String getTextByTableAndCodeAndKey(String code, String key);
}
