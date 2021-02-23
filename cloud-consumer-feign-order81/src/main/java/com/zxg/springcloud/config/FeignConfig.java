package com.zxg.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaogang.zhang
 * @date 2021/2/23
 * @description
 */
@Configuration
public class FeignConfig {

    /**
     * 日志增强
     * feignClient配置日志级别
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        // 请求和响应的头信息,请求和响应的正文及元数据
        return Logger.Level.FULL;
    }
}
