package com.pro516.thrifttogetherbackstage.controller;

import com.pro516.thrifttogetherbackstage.entity.Result;
import com.pro516.thrifttogetherbackstage.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/1
 * Time: 20:00
 */
@Api(tags = "Search 搜索接口")
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/{keyword}/city/{cityId}/user/{userId}")
    @ApiOperation(value = "根据关键词搜索店铺")
    public Result searchShops(
            @ApiParam(value = "关键词", name = "keyword") @PathVariable("keyword") String keyword,
            @ApiParam(value = "城市id", name = "cityId") @PathVariable("cityId") Integer cityId,
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId,
            @ApiParam(value = "起始页 默认0", name = "start") @RequestParam(value = "start", defaultValue = "0") Integer start,
            @ApiParam(value = "每页多少条 默认20", name = "size") @RequestParam(value = "size", defaultValue = "20") Integer size) {

        try {
            return Result.success(searchService.searchShops(cityId, userId, keyword, start, size));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/city/{cityId}/user/{userId}")
    @ApiOperation(value = "根据用户id查询搜索记录")
    public Result searchShops(
            @ApiParam(value = "城市id", name = "cityId") @PathVariable("cityId") Integer cityId,
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId) {

        try {
            return Result.success(searchService.listUserSearchRecords(cityId, userId, 10));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/city/{cityId}")
    @ApiOperation(value = "根据城市id查找热门搜索记录")
    public Result searchShops(
            @ApiParam(value = "城市id", name = "cityId") @PathVariable("cityId") Integer cityId) {

        try {
            return Result.success(searchService.listHotSearchRecords(cityId, 10));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }
}
