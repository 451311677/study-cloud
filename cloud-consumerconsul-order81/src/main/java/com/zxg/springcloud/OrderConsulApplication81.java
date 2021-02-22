package com.zxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xiaogang.zhang
 * @date 2021/2/22
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulApplication81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulApplication81.class,args);
    }
}
