package com.zxg.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
}
