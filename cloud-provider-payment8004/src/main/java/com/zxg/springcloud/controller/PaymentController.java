package com.zxg.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author xiaogang.zhang
 * @date 2021/2/21
 * @description
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/zk")
    public String paymentTestZk(){
        return "springcloud with zookeeper: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
