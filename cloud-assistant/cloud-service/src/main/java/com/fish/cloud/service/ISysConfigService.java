package com.fish.cloud.service;

import com.fish.cloud.bean.model.SysConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.SysConfigAddParam;
import com.fish.cloud.bean.param.SysConfigEditParam;
import com.fish.cloud.common.ret.TupleRet;

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
     * 新增
     *
     * @param sysConfigAddParam
     * @return
     */
    TupleRet add(SysConfigAddParam sysConfigAddParam);

    /**
     * 编辑
     *
     * @param sysConfigEditParam
     * @return
     */
    TupleRet edit(SysConfigEditParam sysConfigEditParam);

}
