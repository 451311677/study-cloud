package com.zxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 入门案例:
 * 1.引入依赖
 * 2.配置application.yml文件
 * 3.发送消息的话,定义一个通道接口,通过接口中内置的messagechannel
 * springcloudstream中内置接口  Source
 * 4.@EnableBinding : 绑定对应通道
 * 5.发送消息的话,通过MessageChannel发送消息
 * 如果需要MessageChannel --> 通过绑定的内置接口获取
 *
 * @author xiaogang.zhang
 * @date 2021/3/15
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitmqProviderApp8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitmqProviderApp8801.class, args);
    }
}
