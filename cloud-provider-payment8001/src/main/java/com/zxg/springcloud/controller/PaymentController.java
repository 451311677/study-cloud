package com.zxg.springcloud.controller;

import com.zxg.springcloud.entities.CommonResult;
import com.zxg.springcloud.entities.Payment;
import com.zxg.springcloud.serivice.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaogang.zhang
 * @date 2021/2/18
 * @description
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    //服务发现
    @Resource
    private DiscoveryClient discoveryClient;


    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult<?> create(@RequestBody Payment payment) {
//        Payment payment = new Payment();
//        payment.setSerial("123");
        int result = paymentService.create(payment);
        log.info("***插入结果: " + result);

        if (result > 0) {
            return new CommonResult<Integer>(200, "插入数据库成功", result);
        } else {
            return new CommonResult<Object>(444, "插入数据库失败", null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*** 查询结果：" + payment);

        if (payment != null) {
            return new CommonResult<Payment>(200, "查询成功，server.port = "+serverPort, payment);
        } else {
            return new CommonResult<Payment>(444, "，没有对应记录，id=" + id, null);
        }
    }

    @GetMapping("/discovery")
    public Object discovery(){
        //All known service IDs.  获取所有实例名
        List<String> services = discoveryClient.getServices();
        services.forEach(s -> {
            log.info("element: "+s);
        });

        //一个微服务名称下的所有实例
        //获取与特定serviceId关联的所有ServiceInstances。
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance->log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri()));

        return this.discoveryClient;
    }

    //测试OpenFeign 超时控制
    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout(){
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPort;
    }
}
