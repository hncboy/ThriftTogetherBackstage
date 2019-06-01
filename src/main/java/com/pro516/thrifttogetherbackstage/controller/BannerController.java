package com.pro516.thrifttogetherbackstage.controller;

import com.pro516.thrifttogetherbackstage.entity.Result;
import com.pro516.thrifttogetherbackstage.service.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 11:52
 */
@Api(tags = "Banner 轮播图接口")
@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping
    @ApiOperation(value = "获取全部轮播图")
    public Result listBanners() {
        return Result.success(bannerService.listBanners());
    }
}
