package com.fish.cloud.service;

import com.fish.cloud.bean.model.SysDicKv;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * 根据系统字典编码获取列表
     * @param shopId
     * @param dicCode
     * @return
     */
    List<SysDicKv> listByDicCode(String shopId, String dicCode);
}