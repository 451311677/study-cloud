package com.zxg.springcloud.serivice;

import com.zxg.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiaogang.zhang
 * @date 2021/2/18
 * @description
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
