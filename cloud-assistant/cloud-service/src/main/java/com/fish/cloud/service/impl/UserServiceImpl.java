package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.UserDto;
import com.fish.cloud.bean.model.Shop;
import com.fish.cloud.bean.model.User;
import com.fish.cloud.bean.param.UserLoginWxParam;
import com.fish.cloud.common.util.*;
import com.fish.cloud.common.util.wx.WxOpenidModel;
import com.fish.cloud.common.util.wx.WxUserInfoModel;
import com.fish.cloud.common.util.wx.WxUtil;
import com.fish.cloud.repo.UserMapper;
import com.fish.cloud.service.IShopService;
import com.fish.cloud.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private IShopService shopService;

    @Override
    public TupleRet loginWx(UserLoginWxParam userLoginWxParam) {
        Shop shop = shopService.getById(SecurityUtil.getAdmin().getShopId());
        if (null == shop) {
            return TupleRet.failed("商城不存在");
        }

        //获取OpenId
        TupleRet openIdResult = WxUtil.getOpenid(userLoginWxParam.getCode(), shop.getWechatAppId(), shop.getWechatSecretKey());
        if (!openIdResult.getIsSuccess()) {
            TupleRet.failed(openIdResult.getMessage());
        }
        WxOpenidModel wxOpenidModel = BeanUtil.convertBean(openIdResult.getData(), WxOpenidModel.class);

        WxUserInfoModel wxUserInfoModel = new WxUserInfoModel();
        if (StringUtils.isNotEmpty(userLoginWxParam.getEncryptedData())) {
            //获取接口提交的UserInfo
            TupleRet userInfoResult = WxUtil.getUserInfo(userLoginWxParam.getIv(), userLoginWxParam.getEncryptedData(), wxOpenidModel.getSessionKey());
            if (!userInfoResult.getIsSuccess()) {
                TupleRet.failed(userInfoResult.getMessage());
            }
            wxUserInfoModel = BeanUtil.convertBean(userInfoResult.getData(), WxUserInfoModel.class);
        }

        //写入表User
        User existUserModel = baseMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getWechatOpenId,wxOpenidModel.getOpenId()));

        String nickName = StringUtils.isEmpty(wxUserInfoModel.getNickName()) ? "" : RegexUtil.replaceAll("/[\\xf0-\\xf7].{3}/", "", wxUserInfoModel.getNickName());
        if (null == existUserModel) {
            User userModel = new User();
            userModel.setUserId(IdUtil.getIdByUUId());
            userModel.setUserName(wxOpenidModel.getOpenId());
            userModel.setLoginPassword(IdUtil.getRandomString(10));
            //userModel.setAuthKey(IdUtil.getRandomString(10));
            //userModel.setAccessToken(IdUtil.getRandomString(10));
            userModel.setRegTime(DateTimeUtil.getCurrentDateTime());
            userModel.setStatus(1);
            userModel.setWechatOpenId(wxOpenidModel.getOpenId());
            userModel.setNickName(nickName);
            //userModel.setAvatarUrl(getAvatarUrl(wxUserInfoModel.getAvatarUrl(), authDto.getStoreId()));
            //userModel.setStoreId(authDto.getStoreId());

            try {
                baseMapper.insert(userModel);
            } catch (Exception ex) {
                // logger.error(ex.getStackTrace());
                CommonResult.failed(ex.getMessage());
            }

            //返回用户信息
            UserDto userRes = new UserDto(
                    userModel.getUserId(),
                    userModel.getWechatOpenId(),
                    userModel.getAccessToken(),
                    userModel.getNickName(),
                    userModel.getAvatarUrl()
            );
            return TupleRet.success(userRes);
        }
        existUserModel.setNickName(nickName);
        //existUserModel.setAvatarUrl(getAvatarUrl(wxUserInfoModel.getAvatarUrl(), authDto.getStoreId()));
        existUserModel.setStatus(1);
        try {
            baseMapper.updateById(existUserModel);
        } catch (Exception ex) {
            // logger.error(ex.getStackTrace());
            TupleRet.failed(ex.getMessage());
        }

        //返回用户信息
        UserDto userRes = new UserDto(
                existUserModel.getUserId(),
                existUserModel.getWechatOpenId(),
                existUserModel.getAccessToken(),
                existUserModel.getNickName(),
                existUserModel.getAvatarUrl()
        );
        return TupleRet.success(userRes);
    }
}
