package com.zxg.springcloud.controller;

import com.zxg.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaogang.zhang
 * @date 2021/2/23
 * @description
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("server.port")
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String re = paymentService.paymentInfoOk(id);
        log.info("result: "+re);
        return re;
    }
    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_Error(@PathVariable("id") Integer id){
        String re = paymentService.paymentInfoError(id);
        log.info("result: "+re);
        return re;
    }
}
