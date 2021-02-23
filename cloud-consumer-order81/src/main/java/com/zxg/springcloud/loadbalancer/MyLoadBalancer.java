package com.zxg.springcloud.loadbalancer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiaogang.zhang
 * @date 2021/2/22
 * @description 自定义LoadBalancer,首先轮询算法
 */
//@Component
public class MyLoadBalancer implements LoadBalancer{
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;

        //自旋锁+CAS
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current +1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*****第几次访问，次数next: "+next);
        return next;
    }


    /**
     *  负载均衡算法
     *
     *  rest接口第几次请求数 %  服务器集群总数量 = 实际调用服务器的位置下标，每次服务器重新启动后rest接口计数从1开始
     *
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {


        int index = getAndIncrement() % serviceInstances.size() ;
        return serviceInstances.get(index);
    }
}
