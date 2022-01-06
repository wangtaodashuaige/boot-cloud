package com.kikyc.auth.controller;

import com.kikyc.common.pojo.User;
import com.kikyc.dependency.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final RedisUtil redisUtil;

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

    @PostMapping("/saveUser")
    @ApiOperation(value = "saveUser", notes = "saveRedis Notes")
    public Boolean saveUser(@RequestBody User user){
        boolean flag = redisUtil.set("user", user);
        return flag;
    }

    @GetMapping("/queryUser")
    @ApiOperation(value = "queryUser", notes = "saveRedis Notes")
    public User queryUser(){
        return (User)redisUtil.get("user");
    }
}
