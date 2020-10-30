package com.fish.cloud.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description
 * @Author fengyh
 * @Date 2020/3/8 18:17
 * @Version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.fish.cloud"})
@MapperScan("com.fish.cloud.repo")
public class ApiApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApiApplication.class);
    }
}
