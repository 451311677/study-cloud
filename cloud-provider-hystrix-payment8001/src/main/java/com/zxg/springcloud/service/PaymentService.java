package com.zxg.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaogang.zhang
 * @date 2021/2/23
 * @description
 */
@Service
public class PaymentService {

    /**
     * 正常方法
     * @param id
     * @return
     */
    public String paymentInfoOk(Integer id){
        return "线程池： "+Thread.currentThread().getName()+" paymentInfo_OK,id="+id;
    }

    /**
     * 出错方法
     * @param id
     * @return
     */
    public String paymentInfoError(Integer id){
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： "+Thread.currentThread().getName()+" paymentInfo_Error,id="+id+"\t"+"耗时 "+time+"s";
    }
}
