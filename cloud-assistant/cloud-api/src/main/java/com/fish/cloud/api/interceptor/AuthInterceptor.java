package com.fish.cloud.api.interceptor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.api.context.ApiResponseUtil;
import com.fish.cloud.common.token.AuthDto;
import com.fish.cloud.common.token.JwtUtil;
import com.fish.cloud.common.ret.ApiResult;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Value("${prop.user-number}")
    private String userNumber;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token"); // 从http请求头中取出token
        // 如果为空，则返回未登录
        if (StrUtil.isEmpty(token)) {
            ApiContextHolder.clearAuthDto();
            ApiResponseUtil.sendJsonMessage(response, ApiResult.unauthorized("token为空"));
            return false;
        }

        // 解析AuthDto
        AuthDto authDto = null;
        try {
            authDto = JwtUtil.getToken(token);
        } catch (JWTDecodeException ex) {
            ApiContextHolder.clearAuthDto();
            ApiResponseUtil.sendJsonMessage(response, ApiResult.unauthorized("JWT解析错误"));
            return false;
        }

        if (ObjectUtil.isNull(authDto)) {
            ApiContextHolder.clearAuthDto();
            ApiResponseUtil.sendJsonMessage(response, ApiResult.unauthorized("JWT解析为空"));
            return false;
        }

        if (!authDto.getUserNumber().equals(userNumber)) {
            ApiContextHolder.clearAuthDto();
            ApiResponseUtil.sendJsonMessage(response, ApiResult.unauthorized("用户不存在"));
            return false;
        }

        if (!JwtUtil.verifierToken(token)) {
            ApiContextHolder.clearAuthDto();
            ApiResponseUtil.sendJsonMessage(response, ApiResult.unauthorized("验证失败"));
            return false;
        }

        return true;
    }
}