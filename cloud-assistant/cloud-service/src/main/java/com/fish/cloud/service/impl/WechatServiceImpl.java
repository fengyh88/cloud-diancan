package com.fish.cloud.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.fish.cloud.bean.Const;
import com.fish.cloud.bean.model.Shop;
import com.fish.cloud.common.util.TupleRet;
import com.fish.cloud.common.util.wx.WxUtil;
import com.fish.cloud.service.IShopService;
import com.fish.cloud.service.IWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service(value = "IWechatService")
public class WechatServiceImpl  implements IWechatService {

    @Autowired
    private IShopService shopService;

    @Override
    public TupleRet generateMiniProgramBarCode(Long shopId) {
        Shop model = shopService.getById(shopId);
        if (null == model) {
            return TupleRet.failed("未查询到店铺信息");
        }

        // 获取token
        String appid = model.getWechatAppId();
        String appsecret = model.getWechatSecretKey();
        TupleRet tokenMethodResult = WxUtil.getAccessToken(appid, appsecret);
        if (!tokenMethodResult.getIsSuccess()) {
            return TupleRet.failed(tokenMethodResult.getMessage());
        }
        String accessToken = tokenMethodResult.getMessage();
        // 二维码中信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("path", "pages/index/index");// 你二维码中跳向的页面
        map.put("scene", shopId);// 携带参数
        String params = JSONObject.toJSONString(map);
        //保存二维码图片路径
        String SAVE_FOLDER = "C:/OTA/";
        String path = SAVE_FOLDER + "9999/";
        //设置文件名称: 当前时间+文件名称
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(d);
        String fileName = shopId + date + ".png";

        // 生成二维码
        try {
            WxUtil.getBarCodeWithInterB(accessToken, params, fileName, path);
        } catch (Exception e) {
            //logger.error(e.getStackTrace());
            return TupleRet.failed(e.getMessage());
        }

        //保存路径到表
//        StorePicReqDto storePicReqDto = new StorePicReqDto();
//        storePicReqDto.setId(0);
//        storePicReqDto.setStoreId(wechatGenetateBarcodeReq.getStoreId());
//        storePicReqDto.setType(9);
//        storePicReqDto.setPicUrl("OTA/9999/" + fileName);
//        storePicReqDto.setNavUrl("");
//        storePicReqDto.setSort(0);
//        TupleRet addStorePicResult = storePicService.addOrEdit(storePicReqDto);
//        if (addStorePicResult.getCode() != 200){
//            return TupleRet.failed(addStorePicResult.getMessage());
//        }
//        String picUrl =  Const.BASE_URL + storePicReqDto.getPicUrl();
//        return TupleRet.success(picUrl);
        return TupleRet.success();
    }
}
