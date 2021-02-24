package com.zxg.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author xiaogang.zhang
 * @date 2021/2/25
 * @description
 */
@Component
public class PaymenFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfoOK(Integer id) {
        return "----------PaymentFallbackService fall back paymentInfo_OK";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "----------PaymentFallbackService fall back paymentInfo_TimeOut";
    }
}
