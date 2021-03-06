package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.model.SysDic;

import java.util.List;

/**
 * <p>
 * 系统字典
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface ISysDicService extends IService<SysDic> {

    /**
     * 所有列表
     *
     * @return
     */
    List<SysDic> all();
}
