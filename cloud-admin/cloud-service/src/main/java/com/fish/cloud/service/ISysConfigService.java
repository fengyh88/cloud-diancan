package com.fish.cloud.service;

import com.fish.cloud.bean.model.SysConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.SysConfigEditParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 系统配置信息
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface ISysConfigService extends IService<SysConfig> {

    /**
     * 编辑
     *
     * @param sysConfigEditParam
     * @return
     */
    TupleRet edit(String shopId, SysConfigEditParam sysConfigEditParam);

    /**
     * 根据key获取值
     *
     * @return
     */
    SysConfig getByKey(String shopId, String key);

    /**
     * 所有列表
     *
     * @return
     */
    List<SysConfig> all(String shopId);
}
