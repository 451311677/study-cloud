package com.zxg.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author xiaogang.zhang
 * @date 2021/2/22
 * @description
 */
@RestController
public class OrderController {
    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String testPaymentConsul(){
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }
}

