package com.fish.cloud.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:api.properties")
@ConfigurationProperties(prefix = "api")
public class SnowflakeBeanValue {

    /**
     * 数据中心ID
     */
    private Integer datacenterId;

    /**
     * 终端ID
     */
    private Integer workerId;

    /**
     * 域名
     */
    private String domainName;

}
