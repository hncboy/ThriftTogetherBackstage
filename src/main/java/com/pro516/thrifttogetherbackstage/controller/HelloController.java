package com.pro516.thrifttogetherbackstage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-13
 * Time: 13:39
 */
@Api(description = "测试接口", tags = "Test")
@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping("/hello")
    @ApiOperation(value = "Hello world测试")
    public String hello() {
        return "hello world";
    }
}
