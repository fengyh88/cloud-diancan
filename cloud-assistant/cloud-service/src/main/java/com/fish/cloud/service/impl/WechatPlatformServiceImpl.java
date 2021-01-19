package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.model.WechatPlatform;
import com.fish.cloud.repo.WechatPlatformMapper;
import com.fish.cloud.service.IWechatPlatformService;
import lombok.var;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信开发平台
 * </p>
 *
 * @author fengyh
 * @since 2020-11-02
 */
@Service
public class WechatPlatformServiceImpl extends ServiceImpl<WechatPlatformMapper, WechatPlatform> implements IWechatPlatformService {

    @Override
    public WechatPlatform getByShopId(Long shopId) {
        var model = baseMapper.selectOne(new LambdaQueryWrapper<WechatPlatform>()
                .eq(WechatPlatform::getShopId, shopId)
                .eq(WechatPlatform::getStatus, 1));
        return model;
    }

}
