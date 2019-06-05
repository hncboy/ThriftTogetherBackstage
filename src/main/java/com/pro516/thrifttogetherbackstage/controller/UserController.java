package com.pro516.thrifttogetherbackstage.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pro516.thrifttogetherbackstage.entity.Result;
import com.pro516.thrifttogetherbackstage.service.UserService;
import com.pro516.thrifttogetherbackstage.config.CosCloud;
import com.qcloud.cos.model.ObjectMetadata;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-13
 * Time: 14:41
 */
@Api(tags = "User 用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Result login(
            @ApiParam(value = "电话", name = "phone") @RequestParam("phone") String phone,
            @ApiParam(value = "密码", name = "password") @RequestParam("password") String password) {
        try {
            return userService.login(phone, password);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "根据用户id获取用户信息")
    public Result findUserByUserId(
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId) {
        try {
            return Result.success(userService.findUserByUserId(userId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/{userId}/avator/{avatorUrl}")
    @ApiOperation(value = "用户修改头像")
    public Result login(
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId,
            @ApiParam(value = "头像url", name = "avatorUrl") @PathVariable("avatorUrl") String avatorUrl) {
        try {
            userService.updateUserAvator(userId, avatorUrl);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @ApiIgnore
    @PostMapping(value = "/uploadPic", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "上传图片返回url")
    public Result uploadPic(MultipartFile file) {
        try {
            InputStream is = file.getInputStream();
            String fileName = file.getOriginalFilename();
            long size = file.getSize();
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(size);
            String fileUrl = CosCloud.uploadPic(fileName, is, metadata);
            return Result.success(fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/{userId}/recentlybrowse")
    @ApiOperation(value = "根据用户id获取用户最近浏览店铺记录")
    public Result listUserRecentlyBrowseShops(
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId) {
        try {
            return Result.success(userService.listUserRecentlyBrowseShops(userId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/{userId}/feedback/{content}")
    @ApiOperation(value = "用户反馈意见")
    public Result userFeedback(
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId,
            @ApiParam(value = "反馈内容", name = "content") @PathVariable("content") String content) {

        try {
            userService.userFeedback(userId, content);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }
}
