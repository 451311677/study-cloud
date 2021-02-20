package com.zxg.springcloud.serivice.impl;

import com.zxg.springcloud.dao.PaymentDao;
import com.zxg.springcloud.entities.Payment;
import com.zxg.springcloud.serivice.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiaogang.zhang
 * @date 2021/2/18
 * @description
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
