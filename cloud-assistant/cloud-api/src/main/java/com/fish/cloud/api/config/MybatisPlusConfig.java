package com.fish.cloud.api.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Description MybatisPlus配置
 * @Author fengyh
 * @Date 2020/3/8 19:01
 * @Version 1.0
 */
@Configuration
@MapperScan("com.fish.cloud.repo")
public class MybatisPlusConfig {
    /**
     * 分页插件
     * @return PaginationInterceptor
     */
    @Bean
    @ConditionalOnMissingBean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * SQL执行效率插件
     * 性能分析拦截器，用于输出每条 SQL 语句及其执行时间
     */
    @Bean
    @Profile({"dev","pro"})// 设置 dev pro 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }
}
