package com.zxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xiaogang.zhang
 * @date 2021/2/23
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
//激活HystrixCommand，开启断路器实现.Springcloud3.0.1开始 Hystrix已经从Spring Cloud Netflix中移除，它是唯一使用此注释的实现。
@EnableCircuitBreaker
public class PaymentHystrixApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixApplication8001.class,args);
    }
}
