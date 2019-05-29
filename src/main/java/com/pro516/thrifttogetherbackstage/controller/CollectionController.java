package com.pro516.thrifttogetherbackstage.controller;

import com.pro516.thrifttogetherbackstage.entity.Result;
import com.pro516.thrifttogetherbackstage.service.CollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/29
 * Time: 14:50
 */
@Api(tags = "Collection 收藏接口")
@RestController
@RequestMapping("/collect")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @PostMapping("user/{userId}/shop/{shopId}")
    @ApiOperation(value = "收藏店铺")
    public Result collectShop(
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId,
            @ApiParam(value = "店铺id", name = "shopId") @PathVariable("shopId") Integer shopId) {

        try {
            collectionService.collectShop(userId, shopId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @PostMapping("user/{userId}/product/{productId}")
    @ApiOperation(value = "收藏商品")
    public Result collectProduct(
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId,
            @ApiParam(value = "商品id", name = "productId") @PathVariable("productId") Integer productId) {
        try {
            collectionService.collectProduct(userId, productId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @PutMapping("user/{userId}/shop/{shopId}")
    @ApiOperation(value = "取消收藏店铺")
    public Result cancelCollectShop(
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId,
            @ApiParam(value = "店铺id", name = "shopId") @PathVariable("shopId") Integer shopId) {

        try {
            collectionService.cancelCollectShop(userId, shopId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @PutMapping("user/{userId}/product/{productId}")
    @ApiOperation(value = "取消收藏商品")
    public Result cancelCollectProduct(
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId,
            @ApiParam(value = "商品id", name = "productId") @PathVariable("productId") Integer productId) {
        try {
            collectionService.cancelCollectProduct(userId, productId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("user/{userId}/product")
    @ApiOperation(value = "获取用户收藏的商品")
    public Result listProductsByUserId(
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId) {
        try {
            return Result.success(collectionService.listProductsByUserId(userId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("user/{userId}/shop")
    @ApiOperation(value = "获取用户收藏的店铺")
    public Result listShopsByUserId(
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId) {
        try {
            return Result.success(collectionService.listShopsByUserId(userId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }
}
