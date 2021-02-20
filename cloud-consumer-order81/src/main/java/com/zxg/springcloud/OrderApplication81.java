package com.zxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xiaogang.zhang
 * @date 2021/2/18
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderApplication81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication81.class,args);
    }


}
