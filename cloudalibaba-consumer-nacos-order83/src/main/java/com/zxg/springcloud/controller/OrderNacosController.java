package com.zxg.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author xiaogang.zhang
 * @date 2021/3/19
 * @description
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderNacosController {

    @Value("${service-url.nacos-user-service}")
    public String serverURL;

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id){
        return restTemplate.getForObject(serverURL+"/payment/nacos/"+id,String.class);
    }

}
