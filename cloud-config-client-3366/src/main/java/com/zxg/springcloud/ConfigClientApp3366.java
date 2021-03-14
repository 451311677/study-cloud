package com.zxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xiaogang.zhang
 * @date 2021/3/14
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApp3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp3366.class,args);
    }
}
