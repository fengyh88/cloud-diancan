package com.fish.cloud.service;

import com.fish.cloud.bean.model.SysDic;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * 所有列表
     *
     * @return
     */
    List<SysDic> all(String shopId);
}
