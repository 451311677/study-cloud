package com.zxg.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaogang.zhang
 * @date 2021/3/8
 * @description
 */
@Configuration
public class GateWayConfig {


    /**
     * 配置一个id为route-name 的路由规则
     * 当访问地址http://localhost:9527/gounei 时会自动转发到地址 : http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        // http://news.baidu.com/guonei
        routes.route("path_route_zxg", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
