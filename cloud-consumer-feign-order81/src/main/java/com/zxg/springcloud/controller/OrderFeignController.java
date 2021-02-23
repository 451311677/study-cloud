package com.zxg.springcloud.controller;

import com.zxg.springcloud.entities.CommonResult;
import com.zxg.springcloud.entities.Payment;
import com.zxg.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaogang.zhang
 * @date 2021/2/22
 * @description 调用本服务的service层
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("***consumer-feign-order       id="+id);
        return paymentFeignService.getPaymentById(id);
    }

    //OpenFeign 超时控制
    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign-ribbon ，客户端默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }

}
