package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.model.WechatPlatform;
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
     * 生成微信小程序菊花码
     * @param
     * @return
     */
    TupleRet<String> generateMiniProgramBarCode(Long tableId);

    /**
     * 根据店铺Id获取信息
     * @param shopId
     * @return
     */
    WechatPlatform getByShopId(Long shopId);
}
