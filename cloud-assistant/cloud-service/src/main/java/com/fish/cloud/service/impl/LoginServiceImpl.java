package com.fish.cloud.service.impl;

import com.fish.cloud.bean.dto.LoginDto;
import com.fish.cloud.bean.param.LoginParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.token.AuthDto;
import com.fish.cloud.common.token.JwtUtil;
import com.fish.cloud.common.util.MD5Util;
import com.fish.cloud.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

    @Value("${prop.user-number}")
    private String userNumber;

    @Value("${prop.user-name}")
    private String userName;

    @Value("${prop.user-password}")
    private String userPassword;

    /**
     * 登录
     * @param loginParam
     * @return
     */
    @Override
    public TupleRet<LoginDto> token(LoginParam loginParam) {
        if (!loginParam.getUserNumber().equals(userNumber)){
            return TupleRet.failed("用户不存在");
        }

        if (!MD5Util.authenticatePassword(userPassword, loginParam.getPassword())) {
            return TupleRet.failed("密码不正确");
        }

        // 缓存CONTEXT
        AuthDto authDto = new AuthDto(userNumber, 0L);
        ApiContextHolder.setAuthDto(authDto);

        // 生成token
        String token = JwtUtil.toToken(authDto);

        // 组装返回
        LoginDto loginDto = new LoginDto();
        loginDto.setToken(token);
        loginDto.setUserName(userName);

        return TupleRet.success(loginDto);
    }
}
