package com.zxg.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaogang.zhang
 * @date 2021/2/23
 * @description
 */
@Service
public class PaymentService {

    //服务降级

    /**
     * 正常方法
     *
     * @param id
     * @return
     */
    public String paymentInfoOk(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_OK,id=" + id;
    }

    /**
     * 出错方法
     * fallbackMethod指定出错时的处理方法
     * <p>
     * 一旦调用服务方法失败并抛出错误信息后，
     * 会自动调用@HystrixCommand标注好的
     * fallbackMethod调用类中的指定方法。
     *
     * 超时或报错都会兜底方案处理
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            //设置自身调用超时时间的峰值,峰值内可以正常运行,  超过了需要有兜底的方法处理,做服务降级fallback
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfoTimeOut(Integer id) {
        int time = 5;
//        int a = 10/0;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_TimeOut,id=" + id + "\t" + "耗时 " + time + "s";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_TimeOutHandler,id=" + id;
    }



    //======服务熔断===============
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            //HystrixCommandProperties配置参数
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),  //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),    //时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("*** id 不能为负数");
        }
        //生成UUID
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号： "+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试，  id: "+id;
    }
}
