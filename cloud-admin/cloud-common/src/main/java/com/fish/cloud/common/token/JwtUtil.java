package com.fish.cloud.common.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fish.cloud.common.util.JsonUtil;

public class JwtUtil {

    private final static String SIGNKEY = "123";

    public static String toToken(AuthDto authDto) {
        String token = "";
        token = JWT.create().withAudience(JsonUtil.objToJson(authDto))// 将 AuthDto 保存到 token 里面
                .sign(Algorithm.HMAC256(SIGNKEY));// 密钥
        return token;
    }

    public static AuthDto getToken(String token) {
        String audienceJSONString = JWT.decode(token).getAudience().get(0);
        return JsonUtil.jsonToObj(audienceJSONString, AuthDto.class);
    }

    public static Boolean verifierToken(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SIGNKEY)).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }
}
