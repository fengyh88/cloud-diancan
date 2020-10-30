package com.fish.cloud.common.util.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fish.cloud.common.util.AesCbcUtil;
import com.fish.cloud.common.util.HttpRequestUtil;
import com.fish.cloud.common.util.StorageUtil;
import com.fish.cloud.common.util.TupleRet;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class WxUtil {

    /**
     *
     * @param code
     * @param wechatAppId 小程序的AppID
     * @param wechatSecretKey 小程序的session-key
     * @return
     */
    public static TupleRet getOpenid(String code, String wechatAppId, String wechatSecretKey) {
        Map map = new HashMap();
        // login code can not be null
        if (StringUtils.isEmpty(code)) {
            return TupleRet.failed("code 不能为空");
        }
        if (StringUtils.isEmpty(wechatAppId)) {
            return TupleRet.failed("wechatAppId 不能为空");
        }
        if (StringUtils.isEmpty(wechatSecretKey)) {
            return TupleRet.failed("wechatSecretKey 不能为空");
        }
        String grantType = "authorization_code";
        // using login code to get sessionId and openId
        String params = "appid=" + wechatAppId + "&secret=" + wechatSecretKey + "&js_code=" + code + "&grant_type=" + grantType;
        // sending request
        String sr = HttpRequestUtil.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        // analysis request content
        JSONObject json = JSON.parseObject(sr);
        // getting session_key
        String sessionKey = json.get("session_key").toString();
        // getting open_id
        String openId = json.get("openid").toString();

        WxOpenidModel wxOpenidModel = new WxOpenidModel(openId, sessionKey);
        return TupleRet.success(wxOpenidModel);
    }

    /**
     *
     * @param iv
     * @param encryptedData
     * @param sessionKey
     * @return
     */
    public static TupleRet getUserInfo(String iv, String encryptedData,String sessionKey){
        try {
            // decoding encrypted info with AES
            String result = AesCbcUtil.decrypt(encryptedData, sessionKey, iv, "UTF-8");
            if (StringUtils.isEmpty(result)){
                return TupleRet.failed("解密失败");
            }

            JSONObject userInfoJSON = JSON.parseObject(result);
            WxUserInfoModel wxUserInfoModel=new WxUserInfoModel();
            wxUserInfoModel.setOpenId(userInfoJSON.get("openId").toString());
            wxUserInfoModel.setNickName(userInfoJSON.get("nickName").toString());
            wxUserInfoModel.setGender(userInfoJSON.get("gender").toString());
            wxUserInfoModel.setCity(userInfoJSON.get("city").toString());
            wxUserInfoModel.setProvince(userInfoJSON.get("province").toString());
            wxUserInfoModel.setCountry(userInfoJSON.get("country").toString());
            wxUserInfoModel.setAvatarUrl(userInfoJSON.get("avatarUrl").toString());
            //wxUserInfoModel.setUnionId(userInfoJSON.get("unionId").toString());

            return TupleRet.success(wxUserInfoModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TupleRet.failed("解密失败");
    }

    /**
     * 获取access_token
     *
     * @param wechatAppId
     * @param wechatSecretKey
     * @return
     */
    public static TupleRet getAccessToken(String wechatAppId, String wechatSecretKey) {
        try {
            if (org.apache.commons.lang3.StringUtils.isEmpty(wechatAppId)) {
                return TupleRet.failed("wechatAppId 不能为空");
            }
            if (org.apache.commons.lang3.StringUtils.isEmpty(wechatSecretKey)) {
                return TupleRet.failed("wechatSecretKey 不能为空");
            }

            String grantType = "client_credential";
            String params = "grant_type=" + grantType + "&appid=" + wechatAppId + "&secret=" + wechatSecretKey;
            // sending request
            String sr = HttpRequestUtil.sendGet("https://api.weixin.qq.com/cgi-bin/token", params);
            JSONObject jsonObject = JSON.parseObject(sr);
            String accessToken = jsonObject.getString("access_token");
            return TupleRet.success(accessToken);
        } catch (Exception e) {
            return TupleRet.failed(e.getMessage());
        }
    }

    // 生成小程序码接口url
    private final static String genetate_barcode_url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=";

    public static String getBarCodeWithInterB(String accessToken, String params, String imgName,String savePath) {
        try {
            InputStream inputStream = HttpRequestUtil.sendPostWithBody(genetate_barcode_url + accessToken, params);
            StorageUtil.saveImgByInputStream(inputStream, savePath, imgName);
        } catch (Exception ex) {
            //logger.error(ex.getStackTrace());
            return ex.getMessage();
        }
        return "";
    }
}
