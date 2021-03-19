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
public class NacosProviderPaymentApp9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderPaymentApp9002.class,args);
    }
}
