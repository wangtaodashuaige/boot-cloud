package com.kikyc.auth.controller;

import com.kikyc.common.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api("server")
public class ServerController {

    @Value("${serverConfig}")
    private String serverConfig;
    @Value("${server.port}")
    private String port;

    @GetMapping("/get")
    @ApiOperation(value = "server", notes = "port")
    public String get(){
        return serverConfig+":"+port;
    }


    @PostMapping("/postTest")
    @ApiOperation(value = "postTest", notes = "test")
    public String postTest(@RequestBody User user){
        return serverConfig+":"+port;
    }
}
