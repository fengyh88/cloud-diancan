package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.model.SysDicKv;

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
     * 所有列表
     *
     * @return
     */
    List<SysDicKv> all();

    /**
     * 根据系统字典编码获取列表
     * @param dicCode
     * @return
     */
    List<SysDicKv> listByDicCode(String dicCode);
}
