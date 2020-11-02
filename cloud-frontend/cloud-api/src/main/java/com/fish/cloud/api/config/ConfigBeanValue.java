package com.fish.cloud.api.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigBeanValue {

    @Value("${foo.isDev} ")
    public Boolean isDev;

    @Value("${foo.shopId}")
    public String shopId;
    @Value("${foo.tableId}")
    public String tableId;
}

