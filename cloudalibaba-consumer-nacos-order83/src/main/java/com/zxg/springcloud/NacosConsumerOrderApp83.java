package com.zxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xiaogang.zhang
 * @date 2021/3/18
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerOrderApp83 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerOrderApp83.class,args);
    }
}
