package com.fish.cloud.common.context;

import com.fish.cloud.common.token.AuthDto;

public class ApiContextHolder {
    private static final ThreadLocal<AuthDto> CONTEXT = new ThreadLocal<>();
    private static final ThreadLocal<Long> CONTEXT_SHOP = new ThreadLocal<>();
    private static final ThreadLocal<Long> CONTEXT_TABLE = new ThreadLocal<>();

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
    public static void setShopId(Long shopId){
        CONTEXT_SHOP.set(shopId);
    }

    public static Long getShopId(){
        return CONTEXT_SHOP.get();
    }

    public static void clearShopId(){
        CONTEXT_SHOP.remove();
    }

    // 台桌
    public static void setTableId(Long tableId){
        CONTEXT_TABLE.set(tableId);
    }

    public static Long getTableId(){
        return CONTEXT_TABLE.get();
    }

    public static void clearTableId(){
        CONTEXT_TABLE.remove();
    }
}
