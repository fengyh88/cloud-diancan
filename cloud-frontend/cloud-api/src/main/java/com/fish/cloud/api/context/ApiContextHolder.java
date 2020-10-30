package com.fish.cloud.api.context;

import com.fish.cloud.common.token.AuthDto;

public class ApiContextHolder {
    private static final ThreadLocal<AuthDto> CONTEXT = new ThreadLocal<>();
    private static final ThreadLocal<String> CONTEXT_SHOP = new ThreadLocal<>();

    // AuthDto
    public static void setAuthDto(AuthDto authDto){
        CONTEXT.set(authDto);
    }

    public static AuthDto getAuthDto(){
        return CONTEXT.get();
    }

    public static void clearAuthDto(){
        CONTEXT.remove();
    }

    //ShopId
    public static void setShopId(String shopId){
        CONTEXT_SHOP.set(shopId);
    }

    public static String getShopId(){
        return CONTEXT_SHOP.get();
    }

    public static void clearShopId(){
        CONTEXT_SHOP.remove();
    }
}
