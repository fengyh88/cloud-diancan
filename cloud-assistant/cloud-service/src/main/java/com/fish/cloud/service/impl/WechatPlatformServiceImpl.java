package com.fish.cloud.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.model.WechatPlatform;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.common.util.ImgStorageUtil;
import com.fish.cloud.common.util.wx.WxUtil;
import com.fish.cloud.repo.WechatPlatformMapper;
import com.fish.cloud.service.IWechatPlatformService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

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

    @Value("${img.upload-folder}")
    private static String uploadFolder;

    @Value("${img.show-prefix}")
    private String showPrefix;

    @Autowired
    private ITableService tableService;

    @Override
    public TupleRet<String> generateMiniProgramBarCode(Long tableId) {
        Table table = tableService.getById(tableId);
        if (ObjectUtil.isNull(table)) {
            return TupleRet.failed("未查询到台桌信息");
        }

        // 获取token
        String accessToken = "";
        WechatPlatform wechatPlatform = getByShopId(ApiContextHolder.getAuthDto().getShopId());
        if (ObjectUtil.isNotNull(wechatPlatform)) {
            accessToken = WxUtil.getAccessToken(wechatPlatform.getWechatAppId(), wechatPlatform.getWechatSecretKey());
        }

        // 二维码中信息
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("path", "pages/index/index");// 二维码中跳向的页面
        paramMap.put("scene", ApiContextHolder.getAuthDto().getShopId().toString() + "|" + tableId.toString());// 携带参数
        String params = JSONObject.toJSONString(paramMap);

        // 生成二维码
        InputStream inputStream = WxUtil.getBarCodeWithInterB(accessToken, params);

        // 存储生成的二维码
        String fileName = ApiContextHolder.getAuthDto().getShopId().toString() + tableId.toString() + DateTimeUtil.getCurrentDateTimeFormat("yyyyMMddHHmmss") + ".png";
        String savePath = uploadFolder + File.separator + "barcode";
        ImgStorageUtil.saveImgByInputStream(inputStream, savePath, fileName);

        // 更新台桌的二维码
        tableService.updateBarcode(tableId, "barcode" + File.separator + fileName);

        // 返回全访问路径
        String barcode = showPrefix + File.separator + "barcode" + File.separator + fileName;
        return TupleRet.success(barcode);
    }

    @Override
    public WechatPlatform getByShopId(Long shopId) {
        var model = baseMapper.selectOne(new LambdaQueryWrapper<WechatPlatform>()
                .eq(WechatPlatform::getShopId, shopId)
                .eq(WechatPlatform::getStatus, 1));
        return model;
    }

}
