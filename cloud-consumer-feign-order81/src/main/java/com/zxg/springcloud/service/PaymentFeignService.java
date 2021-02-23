package com.zxg.springcloud.service;

import com.zxg.springcloud.entities.CommonResult;
import com.zxg.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * OpenFeign 是Spring Cloud 在Feign 的基础上支持了SpringMVC 的注解，
 * 如@RequestMapping等。OpenFeign 的@FeignClient 可以解析SpringMVC的@RequestMapping注解下的接口，
 * 并通过动态代理的方式产生实现类，实现类中做负载均衡并调用其他服务。
 *
 * @author xiaogang.zhang
 * @date 2021/2/22
 * @description 指定微服务下查找RequestMapping注解下的接口
 */
@Component
//指定微服务,Feign自带负载均衡配置项
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    //这个路径对应指定的微服务的路径
    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    //OpenFeign 超时控制
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
