package com.fish.cloud.api.interceptor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.fish.cloud.api.config.ConfigBeanValue;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.api.context.ApiResponseUtil;
import com.fish.cloud.common.token.AuthDto;
import com.fish.cloud.common.token.JwtUtil;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IEmpService;
import com.fish.cloud.service.IShopService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private IEmpService empService;
    @Autowired
    private IShopService shopService;
    @Autowired
    private ConfigBeanValue configBeanValue;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");// 从 http 请求头中取出 token
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

        var emp = empService.getById(authDto.getEmpId());
        if (ObjectUtil.isNull(emp)) {
            ApiContextHolder.clearAuthDto();
            ApiResponseUtil.sendJsonMessage(response, ApiResult.unauthorized("员工不存在"));
            return false;
        }

        var shop = shopService.getById(authDto.getShopId());
        if (ObjectUtil.isNull(shop)) {
            ApiContextHolder.clearAuthDto();
            ApiResponseUtil.sendJsonMessage(response, ApiResult.unauthorized("店铺不存在"));
            return false;
        }

        if (!JwtUtil.verifierToken(token)) {
            ApiContextHolder.clearAuthDto();
            ApiResponseUtil.sendJsonMessage(response, ApiResult.unauthorized("验证失败"));
            return false;
        }

        // 缓存CONTEXT
        ApiContextHolder.setAuthDto(authDto);

        return true;
    }
}