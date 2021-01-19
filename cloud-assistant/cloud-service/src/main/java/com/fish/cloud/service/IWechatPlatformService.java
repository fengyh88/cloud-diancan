package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.model.WechatPlatform;
import com.fish.cloud.bean.param.ShopAddParam;
import com.fish.cloud.bean.param.ShopEditParam;
import com.fish.cloud.bean.param.WechatPlatformAddParam;
import com.fish.cloud.bean.param.WechatPlatformEditParam;
import com.fish.cloud.common.ret.TupleRet;

/**
 * <p>
 * 微信开发平台
 * </p>
 *
 * @author fengyh
 * @since 2020-11-02
 */
public interface IWechatPlatformService extends IService<WechatPlatform> {

    /**
     * 添加
     * @param wechatPlatformAddParam
     * @return
     */
    TupleRet add(WechatPlatformAddParam wechatPlatformAddParam);

    /**
     * 编辑
     * @param wechatPlatformEditParam
     * @return
     */
    TupleRet edit(WechatPlatformEditParam wechatPlatformEditParam);

}
