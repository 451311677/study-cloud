package com.zxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xiaogang.zhang
 * @date 2021/2/23
 * @description
 */
@SpringBootApplication
//激活Feign
@EnableFeignClients
public class OrderHystrixApp81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixApp81.class,args);
    }

}
