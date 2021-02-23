package com.zxg.springcloud;

import org.aspectj.weaver.ast.Or;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xiaogang.zhang
 * @date 2021/2/22
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
//激活feign
@EnableFeignClients
public class OrderFeignApplication81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApplication81.class,args);
    }
}
