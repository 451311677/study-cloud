package com.zxg.springcloud.controller;

import com.zxg.springcloud.entities.CommonResult;
import com.zxg.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon 负载均衡轮询算法：
 * rest 接口第几次请求数 % 服务器集群总数量 = 实际调用服务服务器位置下标，每次服务重启动后rest接口技术从1开始
 *
 * @author xiaogang.zhang
 * @date 2021/2/18
 * @description
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    //单机版
//    public static final String PAYMENT_URL = "http://localhost:8001";

    //集群吧，使用微服务名称来调用
    //需要@LoadBalanced注解修饰RestTemplate，否则restTemplate无法识别微服务名称
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("*** consumer");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
//        return restTemplate.postForEntity(PAYMENT_URL+"/payment/create",payment,CommonResult.class).getBody();
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("*** consumer getPayment id="+id);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/payment/get2/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin/",String.class);
    }



}
