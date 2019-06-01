package com.pro516.thrifttogetherbackstage.controller;

import com.pro516.thrifttogetherbackstage.entity.Result;
import com.pro516.thrifttogetherbackstage.service.CouponService;
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
 * Time: 10:33
 */
@Api(tags = "Coupon 优惠券接口")
@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping
    @ApiOperation(value = "获取全部优惠券")
    public Result listSimpleCoupons() {
        try {
            return Result.success(couponService.listSimpleCoupons());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/{couponId}")
    @ApiOperation(value = "根据优惠卷id查询优惠券详情")
    public Result getCouponDetailsByCouponId(
            @ApiParam(value = "优惠券id", name = "couponId") @PathVariable("couponId") Integer couponId) {

        try {
            return Result.success(couponService.getCouponDetailsByCouponId(couponId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/user/{userId}")
    @ApiOperation(value = "根据用户id查询领取的优惠券")
    public Result listUserCouponsByUserId(
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId) {

        try {
            return Result.success(couponService.listUserCouponsByUserId(userId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }
}
