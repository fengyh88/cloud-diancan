package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.model.SysConfig;

import java.util.List;

/**
 * <p>
 * 系统配置信息
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface ISysConfigService extends IService<SysConfig> {

    /**
     * 根据key获取值
     *
     * @return
     */
    SysConfig getByKey(String key);

    /**
     * 所有列表
     *
     * @return
     */
    List<SysConfig> all();

}
