package com.zxg.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
//定义默认通用的fallback函数
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    /**
     * 默认的兜底函数
     * @param id
     * @return
     */
    @HystrixCommand
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id){
//        int a = 10/0;
        return paymentHystrixService.paymentInfoOK(id);
    }


    /**
     * 消费者端 定义兜底处理fallback,捕捉运行异常，超时异常
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            //设置自身调用超时时间的峰值,峰值内可以正常运行,  超过了需要有兜底的方法处理,做服务降级fallback
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfoTimeOut(id);
    }

    /**
     * 超时/报错 处理方法
     * @param id
     * @return
     */
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "消费者81 .。。。。。。。。。。";
    }

    /**
     * 通用的默认处理方法
     * @return
     */
    public String payment_Global_FallbackMethod(){
        return "Global 异常处理信息，请稍后再试";
    }
}
