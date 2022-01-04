package com.kikyc.bootgateway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ServerController {
    @Value("${serverConfig}")
    private String serverConfig;
    @Value("${server.port}")
    private String port;

    @GetMapping("/get")
    public String get(){
        return serverConfig+":"+port;
    }
}
