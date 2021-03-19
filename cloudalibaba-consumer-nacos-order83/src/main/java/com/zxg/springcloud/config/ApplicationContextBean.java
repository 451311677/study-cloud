package com.zxg.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaogang.zhang
 * @date 2021/3/18
 * @description
 */
@Configuration
public class ApplicationContextBean {

    @Bean
    @LoadBalanced   //负载均衡
    public  RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
