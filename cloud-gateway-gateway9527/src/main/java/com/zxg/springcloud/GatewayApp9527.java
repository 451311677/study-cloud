package com.zxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xiaogang.zhang
 * @date 2021/3/8
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApp9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApp9527.class,args);
    }
}
