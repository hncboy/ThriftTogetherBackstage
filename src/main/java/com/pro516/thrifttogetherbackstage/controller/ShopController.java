package com.pro516.thrifttogetherbackstage.controller;

import com.pro516.thrifttogetherbackstage.entity.Shop;
import com.pro516.thrifttogetherbackstage.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 14:10
 */
@Api(description = "店铺接口", tags = "Shop")
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping
    @ApiOperation(value = "根据城市id，分类id和细分id筛选店铺")
    public ResponseEntity<List<Shop>> listShopsBySubdivisionId(
            @ApiParam(value = "城市id", name = "cityId") @RequestParam("cityId") Integer cityId,
            @ApiParam(value = "分类id", name = "categoryId") @RequestParam(value = "categoryId", required = false) Integer categoryId,
            @ApiParam(value = "细分id", name = "subdivisionId") @RequestParam(value = "subdivisionId", required = false) Integer subdivisionId) {
        if (categoryId != null) {
            if (subdivisionId != null) {
                return ResponseEntity.ok(shopService.listShopsBySubdivisionId(cityId, categoryId, subdivisionId));
            }
            return ResponseEntity.ok(shopService.listShopsByCategoryId(cityId, categoryId));
        }
        return ResponseEntity.ok(shopService.listShopsByCityId(cityId));

    }

    @GetMapping("/recommend")
    @ApiOperation(value = "查询每日推荐的店铺")
    public ResponseEntity<List<Shop>> listRecommendedDailyShops() {
        return ResponseEntity.ok(shopService.listRecommendedDailyShops());
    }
}
