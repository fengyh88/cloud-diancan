package com.fish.cloud.api.config;

import cn.hutool.core.lang.Snowflake;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class SnowflakeConfig {

    private final SnowflakeBeanValue snowflakeBeanValue;

    @Bean
    public Snowflake snowflake() {
        return new Snowflake(snowflakeBeanValue.getWorkerId(), snowflakeBeanValue.getDatacenterId());
    }

}
