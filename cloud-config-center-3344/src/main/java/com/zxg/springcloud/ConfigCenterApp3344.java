package com.zxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author xiaogang.zhang
 * @date 2021/3/10
 * @description 配置中心服务端
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterApp3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterApp3344.class,args);
    }
}
