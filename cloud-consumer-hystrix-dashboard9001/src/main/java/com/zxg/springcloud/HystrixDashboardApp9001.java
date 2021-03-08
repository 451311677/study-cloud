package com.zxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author xiaogang.zhang
 * @date 2021/2/25
 * @description
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApp9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApp9001.class,args);
    }
}
