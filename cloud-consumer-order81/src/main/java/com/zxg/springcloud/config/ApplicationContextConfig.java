package com.zxg.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaogang.zhang
 * @date 2021/2/18
 * @description
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * LoadBalanced注解 负载均衡，否则restTemplate无法识别微服务名称
     * @return restTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
