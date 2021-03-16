package com.zxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xiaogang.zhang
 * @date 2021/3/16
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitConsumer8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitConsumer8803.class,args);
    }
}
