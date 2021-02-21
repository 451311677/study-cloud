package com.zxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xiaogang.zhang
 * @date 2021/2/21
 * @description
 */
@SpringBootApplication
//该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@EnableDiscoveryClient
public class OrderZKApplication81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKApplication81.class,args);
    }
}
