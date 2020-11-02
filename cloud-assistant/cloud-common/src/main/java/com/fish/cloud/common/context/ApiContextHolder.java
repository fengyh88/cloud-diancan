package com.fish.cloud.common.context;

import com.fish.cloud.common.token.AuthDto;

public class ApiContextHolder {
    private static final ThreadLocal<AuthDto> CONTEXT = new ThreadLocal<>();

    // AuthDto
    public static void setAuthDto(AuthDto authDto) {
        CONTEXT.set(authDto);
    }

    public static AuthDto getAuthDto() {
        return CONTEXT.get();
    }

    public static void clearAuthDto() {
        CONTEXT.remove();
    }
}
