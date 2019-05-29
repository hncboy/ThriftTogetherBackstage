package com.pro516.thrifttogetherbackstage.controller;

import com.pro516.thrifttogetherbackstage.entity.Result;
import com.pro516.thrifttogetherbackstage.entity.User;
import com.pro516.thrifttogetherbackstage.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-13
 * Time: 14:41
 */
@Api(description = "用户接口", tags = "User")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public ResponseEntity<Map<String, String>> login(
            @ApiParam(value = "电话", name = "phone") @RequestParam("phone") String phone,
            @ApiParam(value = "密码", name = "password") @RequestParam("password") String password) {
        return ResponseEntity.ok(userService.login(phone, password));
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "根据用户id获取用户信息")
    public ResponseEntity<User> findUserByUserId(
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId) {
        return ResponseEntity.ok(userService.findUserByUserId(userId));
    }
}
