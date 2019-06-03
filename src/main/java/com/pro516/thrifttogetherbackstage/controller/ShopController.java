package com.pro516.thrifttogetherbackstage.controller;

import com.pro516.thrifttogetherbackstage.entity.Result;
import com.pro516.thrifttogetherbackstage.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 14:10
 */
@Api(tags = "Shop 店铺接口")
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/city/{cityId}")
    @ApiOperation(value = "根据城市id筛选店铺")
    public Result listShopsByCityId(
            @ApiParam(value = "城市id", name = "cityId") @PathVariable("cityId") Integer cityId) {

        try {
            return Result.success(shopService.listShopsByCityId(cityId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/city/{cityId}/category/{categoryId}")
    @ApiOperation(value = "根据城市id，分类id筛选店铺")
    public Result listShopsByCategoryId(
            @ApiParam(value = "城市id", name = "cityId") @PathVariable("cityId") Integer cityId,
            @ApiParam(value = "分类id", name = "categoryId") @PathVariable("categoryId") Integer categoryId) {

        try {
            return Result.success(shopService.listShopsByCategoryId(cityId, categoryId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/city/{cityId}/category/{categoryId}/subdivision/{subdivisionId}")
    @ApiOperation(value = "根据城市id，分类id和细分id筛选店铺")
    public Result listShopsBySubdivisionId(
            @ApiParam(value = "城市id", name = "cityId") @PathVariable("cityId") Integer cityId,
            @ApiParam(value = "分类id", name = "categoryId") @PathVariable("categoryId") Integer categoryId,
            @ApiParam(value = "细分id", name = "subdivisionId") @PathVariable("subdivisionId") Integer subdivisionId) {

        try {
            return Result.success(shopService.listShopsBySubdivisionId(cityId, categoryId, subdivisionId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/{shopId}/user/{userId}")
    @ApiOperation(value = "根据用户id和店铺id查询店铺详情")
    public Result getShopDetails(
            @ApiParam(value = "店铺id", name = "shopId") @PathVariable("shopId") Integer shopId,
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId) {

        return Result.success(shopService.getShopDetails(shopId, userId));
    }

    @GetMapping("/city/{cityId}/lat/{userLat}/lng/{userLng}")
    @ApiOperation(value = "根据城市id，用户所在经纬度查询周边")
    public Result listDiscoverShops(
            @ApiParam(value = "城市id", name = "cityId") @PathVariable("cityId") Integer cityId,
            @ApiParam(value = "用户所在纬度", name = "userLat") @PathVariable("userLat") Double userLat,
            @ApiParam(value = "用户所在经度", name = "userLng") @PathVariable("userLng") Double userLng,
            @ApiParam(value = "起始页 默认0", name = "start") @RequestParam(value = "start", defaultValue = "0") Integer start,
            @ApiParam(value = "每页多少条 默认20", name = "size") @RequestParam(value = "size", defaultValue = "20") Integer size) {

        try {
            return Result.success(shopService.listDiscoverShops(cityId, userLng, userLat, start, size));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/{shopId}/user/{userId}/product")
    @ApiOperation(value = "根据店铺id和用户id查询店铺商品详情列表")
    public Result listDetailProductsByShopId(
            @ApiParam(value = "店铺id", name = "shopId") @PathVariable("shopId") Integer shopId,
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId) {

        try {
            return Result.success(shopService.listDetailProducts(shopId, userId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/city/{cityId}/recommend")
    @ApiOperation(value = "根据城市id获取每日推荐的店铺")
    public Result listRecommendedDailyShopsByCityId(
            @ApiParam(value = "城市id", name = "cityId") @PathVariable("cityId") Integer cityId) {
        // TODO 城市id还没用
        return Result.success(shopService.listRecommendedDailyShopsByCityId(cityId));
    }

    @GetMapping("/city/{cityId}/user/{userId}/lookingaround")
    @ApiOperation(value = "根据城市id和用户id获取随便看看的店铺")
    public Result listLookingAroundShops(
            @ApiParam(value = "城市id", name = "cityId") @PathVariable("cityId") Integer cityId,
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId) {

        try {
            return Result.success(shopService.listLookingAroundShops(cityId, userId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }
}
