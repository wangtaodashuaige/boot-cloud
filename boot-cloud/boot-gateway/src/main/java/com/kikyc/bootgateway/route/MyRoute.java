package com.kikyc.bootgateway.route;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * 自定义路由转发规则
 */
@Configuration
@RequiredArgsConstructor
public class MyRoute {

    private final DiscoveryClient discoveryClient;

    private static String PREFIX = "lb://";

    @Bean
    @Order(100000)
    public RouteLocator routeLocator(RouteLocatorBuilder locatorBuilder) {
        // 获取nacos上所有服务名
        List<String> services = discoveryClient.getServices();
        if (services == null || services.size() == 0) {
            return locatorBuilder.routes().build();
        }
        Builder routes = locatorBuilder.routes();
        for (String service : services) {
            String url = service.substring(service.lastIndexOf("-")+1);
            System.out.println("/"+url+"_m/**"+"--->"+PREFIX+service);
            routes.route(service,p -> p.path("/"+url+"_m/**").filters(f -> f.stripPrefix(1)).uri(PREFIX+service));
        }
        return routes.build();
    }

}

