package com.kikyc.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootGatewayApplication.class, args);
    }

}
