package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.User;
import com.fish.cloud.bean.model.WechatPlatform;
import com.fish.cloud.bean.param.LoginParam;
import com.fish.cloud.bean.param.UserLoginWxParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.token.AuthDto;
import com.fish.cloud.common.token.JwtUtil;
import com.fish.cloud.common.util.*;
import com.fish.cloud.common.util.wx.WxOpenidModel;
import com.fish.cloud.common.util.wx.WxUserInfoModel;
import com.fish.cloud.common.util.wx.WxUtil;
import com.fish.cloud.service.*;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 * 登录
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private IUserService userService;
    @Autowired
    private IWechatPlatformService wechatPlatformService;

    @Override
    public TupleRet loginWx(UserLoginWxParam userLoginWxParam) {
        // 获取微信公众号配置信息（服务商）
        List<WechatPlatform> wechatPlatforms = wechatPlatformService.list();
        if (CollectionUtils.isEmpty(wechatPlatforms)){
            return TupleRet.failed("微信公众平台配置错误");
        }

        WechatPlatform wechatPlatform = wechatPlatforms.get(0);
        // 获取OpenId
        TupleRet openIdResult = WxUtil.getOpenidAndSessionKeyByCode(userLoginWxParam.getCode(), wechatPlatform.getWechatAppId(), wechatPlatform.getWechatSecretKey());
        if (!openIdResult.getSuccess()) {
            return TupleRet.failed("获取OpenId错误");
        }
        WxOpenidModel wxOpenidModel = BeanUtil.convertBean(openIdResult.getData(), WxOpenidModel.class);

        // 解密获取用户信息UserInfo
        WxUserInfoModel wxUserInfoModel = new WxUserInfoModel();
        if (StringUtils.isNotEmpty(userLoginWxParam.getEncryptedData())) {
            TupleRet userInfoResult = WxUtil.getUserInfoBySessionKey(userLoginWxParam.getIv(), userLoginWxParam.getEncryptedData(), wxOpenidModel.getSessionKey());
            if (!userInfoResult.getSuccess()) {
                return TupleRet.failed("解密获取用户信息错误");
            }
            wxUserInfoModel = BeanUtil.convertBean(userInfoResult.getData(), WxUserInfoModel.class);
        } else {
            wxUserInfoModel.setCountry(userLoginWxParam.getCountry());
            wxUserInfoModel.setProvince(userLoginWxParam.getProvince());
            wxUserInfoModel.setCity(userLoginWxParam.getCity());
            wxUserInfoModel.setAvatarUrl(userLoginWxParam.getAvatarUrl());
            wxUserInfoModel.setGender(userLoginWxParam.getGender() == "1" ? "M" : "F");
            wxUserInfoModel.setNickName(userLoginWxParam.getNickName());
            wxUserInfoModel.setOpenId(wxOpenidModel.getOpenId());
        }

        // 根据openId获取平台中用户信息
        User modelDb = userService.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getWechatOpenId, wxOpenidModel.getOpenId()));

        // 写入数据库中User信息
        if (ObjectUtils.isEmpty(modelDb)) {
            // 不存在该用户信息
            User model = new User();
            // 生成UserId随机码
            model.setUserId(IdUtil.getIdByUUId());
            model.setUserName(wxOpenidModel.getOpenId());
            // 随机10位数密码，用户不用密码登录
            model.setPassword(IdUtil.getRandomString(10));

            // 用户OpenId唯一
            model.setWechatOpenId(wxOpenidModel.getOpenId());
            // userModel.setWechatUnionId(wxUserInfoModel.getUnionId());
            // 用户昵称
            String nickName = StringUtils.isEmpty(wxUserInfoModel.getNickName()) ? "" :
                    RegexUtil.replaceAll("/[\\xf0-\\xf7].{3}/", "", wxUserInfoModel.getNickName());
            model.setNickName(nickName);
            model.setImg(wxUserInfoModel.getAvatarUrl());
            model.setGender(wxUserInfoModel.getGender());
//            userModel.setCountry(wxUserInfoModel.getCountry());
//            userModel.setProvince(wxUserInfoModel.getProvince());
//            userModel.setCity(wxUserInfoModel.getCity());

            model.setRegTime(DateTimeUtil.getCurrentDateTime());
            model.setLastLoginTime(DateTimeUtil.getCurrentDateTime());
            model.setStatus(1);

            try {
                userService.save(model);
            } catch (Exception ex) {
                log.error(ex.getMessage());
                return TupleRet.failed(ex.getMessage());
            }

            // 返回token
            AuthDto authDto = new AuthDto(model.getUserId());
            String token = JwtUtil.toToken(authDto);
            return TupleRet.success(token);
        } else {
            // 存在该用户信息
            String nickName = StringUtils.isEmpty(wxUserInfoModel.getNickName()) ? "" :
                    RegexUtil.replaceAll("/[\\xf0-\\xf7].{3}/", "", wxUserInfoModel.getNickName());
            modelDb.setUserName(wxOpenidModel.getOpenId());
            modelDb.setNickName(nickName);
            modelDb.setImg(wxUserInfoModel.getAvatarUrl());
            modelDb.setGender(wxUserInfoModel.getGender());
            // 用户OpenId唯一
            modelDb.setWechatOpenId(wxOpenidModel.getOpenId());
            modelDb.setLastLoginTime(DateTimeUtil.getCurrentDateTime());
            modelDb.setStatus(1);
            try {
                userService.updateById(modelDb);
            } catch (Exception ex) {
                log.error(ex.getMessage());
                return TupleRet.failed(ex.getMessage());
            }

            // 返回token
            AuthDto authDto = new AuthDto(modelDb.getUserId());
            String token = JwtUtil.toToken(authDto);
            return TupleRet.success(token);
        }
    }

    @Override
    public TupleRet loginWxOnly(UserLoginWxParam userLoginWxParam) {
        // 获取微信公众号配置信息（服务商）
        List<WechatPlatform> wechatPlatforms = wechatPlatformService.list();
        if (CollectionUtils.isEmpty(wechatPlatforms)){
            return TupleRet.failed("微信公众平台配置错误");
        }

        WechatPlatform wechatPlatform = wechatPlatforms.get(0);
        // 获取OpenId
        TupleRet openIdResult = WxUtil.getOpenidAndSessionKeyByCode(userLoginWxParam.getCode(), wechatPlatform.getWechatAppId(), wechatPlatform.getWechatSecretKey());
        if (!openIdResult.getSuccess()) {
            return TupleRet.failed("获取OpenId错误");
        }
        WxOpenidModel wxOpenidModel = BeanUtil.convertBean(openIdResult.getData(), WxOpenidModel.class);

        // 解密获取用户信息UserInfo
        WxUserInfoModel wxUserInfoModel = new WxUserInfoModel();
        wxUserInfoModel.setOpenId(wxOpenidModel.getOpenId());

        // 根据openId获取平台中用户信息
        User modelDb = userService.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getWechatOpenId, wxOpenidModel.getOpenId()),false);

        // 写入数据库中User信息
        if (ObjectUtils.isEmpty(modelDb)) {
            // 不存在该用户信息
            User model = new User();
            // 生成UserId随机码
            model.setUserId(IdUtil.getIdByUUId());
            model.setUserName(wxOpenidModel.getOpenId());
            // 随机10位数密码，用户不用密码登录
            model.setPassword(IdUtil.getRandomString(10));

            // 用户OpenId唯一
            model.setWechatOpenId(wxOpenidModel.getOpenId());
            // userModel.setWechatUnionId(wxUserInfoModel.getUnionId());
            // 用户昵称
            String nickName = StringUtils.isEmpty(wxUserInfoModel.getNickName()) ? "" :
                    RegexUtil.replaceAll("/[\\xf0-\\xf7].{3}/", "", wxUserInfoModel.getNickName());
            model.setNickName(nickName);
            model.setImg(wxUserInfoModel.getAvatarUrl());
            model.setGender(wxUserInfoModel.getGender());

            model.setRegTime(DateTimeUtil.getCurrentDateTime());
            model.setLastLoginTime(DateTimeUtil.getCurrentDateTime());
            model.setStatus(1);

            try {
                userService.save(model);
            } catch (Exception ex) {
                log.error(ex.getMessage());
                return TupleRet.failed(ex.getMessage());
            }

            // 返回token
            AuthDto authDto = new AuthDto(model.getUserId());
            String token = JwtUtil.toToken(authDto);
            return TupleRet.success(token);
        } else {
            // 存在该用户信息
            String nickName = StringUtils.isEmpty(wxUserInfoModel.getNickName()) ? "" :
                    RegexUtil.replaceAll("/[\\xf0-\\xf7].{3}/", "", wxUserInfoModel.getNickName());
            modelDb.setUserName(wxOpenidModel.getOpenId());
            modelDb.setNickName(nickName);
            modelDb.setImg(wxUserInfoModel.getAvatarUrl());
            modelDb.setGender(wxUserInfoModel.getGender());
            // 用户OpenId唯一
            modelDb.setWechatOpenId(wxOpenidModel.getOpenId());
            // existUserModel.setWechatUnionId(wxUserInfoModel.getUnionId());
            modelDb.setLastLoginTime(DateTimeUtil.getCurrentDateTime());
            modelDb.setStatus(1);
            try {
                userService.updateById(modelDb);
            } catch (Exception ex) {
                log.error(ex.getMessage());
                return TupleRet.failed(ex.getMessage());
            }

            // 返回token
            AuthDto authDto = new AuthDto(modelDb.getUserId());
            String token = JwtUtil.toToken(authDto);
            return TupleRet.success(token);
        }
    }
}
