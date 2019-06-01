package com.pro516.thrifttogetherbackstage.controller;

import com.pro516.thrifttogetherbackstage.entity.Result;
import com.pro516.thrifttogetherbackstage.entity.Review;
import com.pro516.thrifttogetherbackstage.service.ReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/30
 * Time: 17:55
 */
@Api(tags = "Review 评价接口")
@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    @ApiOperation(value = "用户评价订单")
    public Result reviewOrder(@RequestBody Review review) {
        try {
            reviewService.reviewOrder(review);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/shop/{shopId}")
    @ApiOperation(value = "根据店铺id获取评价信息")
    public Result listReviewsByProductId(
            @ApiParam(value = "店铺id", name = "shopId") @PathVariable("shopId") Integer shopId) {
        // FIXME 目前只能获取带图片评价，不然报错
        try {
            return Result.success(reviewService.listReviewsByShopId(shopId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }
}
