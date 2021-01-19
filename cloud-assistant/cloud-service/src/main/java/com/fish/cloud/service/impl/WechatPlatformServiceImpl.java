package com.fish.cloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.model.Shop;
import com.fish.cloud.bean.model.WechatPlatform;
import com.fish.cloud.bean.param.WechatPlatformAddParam;
import com.fish.cloud.bean.param.WechatPlatformEditParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.WechatPlatformMapper;
import com.fish.cloud.service.IWechatPlatformService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 微信开发平台
 * </p>
 *
 * @author fengyh
 * @since 2020-11-02
 */
@Service
@Slf4j
public class WechatPlatformServiceImpl extends ServiceImpl<WechatPlatformMapper, WechatPlatform> implements IWechatPlatformService {

    @Override
    public TupleRet add(WechatPlatformAddParam wechatPlatformAddParam) {
        var modelDb = baseMapper.selectOne(new LambdaQueryWrapper<WechatPlatform>()
                .eq(WechatPlatform::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(WechatPlatform::getStatus, 1));
        if (!ObjectUtils.isEmpty(modelDb)) {
            return TupleRet.failed("店铺不得重复配置");
        }

        var model = new WechatPlatform();
        BeanUtil.copyProperties(wechatPlatformAddParam, model);
        model.setShopId(ApiContextHolder.getAuthDto().getShopId());
        model.setStatus(1);
        model.setCreateTime(DateTimeUtil.getCurrentDateTime());
        try {
            baseMapper.insert(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success();
    }

    @Override
    public TupleRet edit(WechatPlatformEditParam wechatPlatformEditParam) {
        var model = baseMapper.selectById(wechatPlatformEditParam.getId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("未查询到配置信息");
        }

        try {
            BeanUtil.copyProperties(wechatPlatformEditParam, model);
            model.setUpdateTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success();
    }
}
