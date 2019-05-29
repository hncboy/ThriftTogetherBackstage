package com.pro516.thrifttogetherbackstage.controller;

import com.pro516.thrifttogetherbackstage.entity.Result;
import com.pro516.thrifttogetherbackstage.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/recommend")
    @ApiOperation(value = "查询每日推荐的店铺")
    public Result listRecommendedDailyShops() {
        return Result.success(shopService.listRecommendedDailyShops());
    }
}
