package com.zxg.springcloud.controller;

import com.zxg.springcloud.entities.CommonResult;
import com.zxg.springcloud.entities.Payment;
import com.zxg.springcloud.serivice.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @PostMapping("/create")
    public CommonResult<?> create(Payment payment) {
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
            return new CommonResult<Payment>(200, "查询成功", payment);
        } else {
            return new CommonResult<Payment>(444, "，没有对应记录，id=" + id, null);
        }
    }
}
