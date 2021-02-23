package com.zxg.springcloud.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * com.netflix.loadbalancer.RoundRobinRule
 * 轮询
 * com.netflix.loadbalancer.RandomRule
 * 随机
 * com.netflix.loadbalancer.RetryRule
 * 先按照RoundRobinRule的策略获取服务,如果获取服务失败则在指定时间内进行重试,获取可用的服务
 * WeightedResponseTimeRule
 * 对RoundRobinRule的扩展,响应速度越快的实例选择权重越多大,越容易被选择
 * BestAvailableRule
 * 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务,然后选择一个并发量最小的服务
 * AvailabilityFilteringRule
 * 先过滤掉故障实例,再选择并发较小的实例
 * ZoneAvoidanceRule
 * 默认规则,复合判断server所在区域的性能和server的可用性选择服务器
 *
 * @author xiaogang.zhang
 * @date 2021/2/22
 * @description 自定义负载均衡算法
 */

//@Configuration
public class MySelfRule {

//    @Bean
//    public IRule myRule(){
//        //定义为随机
//        return new RandomRule();
//    }
}
