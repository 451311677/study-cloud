package com.zxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import sun.security.krb5.Config;

/**
 * @author xiaogang.zhang
 * @date 2021/3/11
 * @description 配置中心客户端
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApp3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp3355.class,args);
    }
}
