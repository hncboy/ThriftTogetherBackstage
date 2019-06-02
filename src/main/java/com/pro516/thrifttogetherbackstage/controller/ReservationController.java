package com.pro516.thrifttogetherbackstage.controller;

import com.pro516.thrifttogetherbackstage.entity.Reservation;
import com.pro516.thrifttogetherbackstage.entity.Result;
import com.pro516.thrifttogetherbackstage.service.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/2
 * Time: 10:09
 */
@Api(tags = "Reservation 预约接口")
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    @ApiOperation(value = "用户预约店铺")
    public Result reviewOrder(@RequestBody Reservation reservation) {
        try {
            reservationService.insertReservation(reservation);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/cancel/{reservationId}")
    @ApiOperation(value = "用户取消预约")
    public Result cancelReservation(
            @ApiParam(value = "预约id", name = "reservationId") @PathVariable("reservationId") Integer reservationId) {

        try {
            reservationService.cancelReservation(reservationId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/user/{userId}")
    @ApiOperation(value = "根据用户id查询预约信息")
    public Result listSimpleReservationsByUserId(
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId) {

        try {
            return Result.success( reservationService.listSimpleReservationsByUserId(userId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }
}
