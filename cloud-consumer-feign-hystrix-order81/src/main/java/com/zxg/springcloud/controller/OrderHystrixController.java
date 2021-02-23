package com.zxg.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zxg.springcloud.service.PaymentHystrixService;

import javax.annotation.Resource;

/**
 * @author xiaogang.zhang
 * @date 2021/2/23
 * @description
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfoOK(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoError(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfoError(id);
    }
}
