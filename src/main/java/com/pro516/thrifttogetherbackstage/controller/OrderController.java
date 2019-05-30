package com.pro516.thrifttogetherbackstage.controller;

import com.pro516.thrifttogetherbackstage.entity.Result;
import com.pro516.thrifttogetherbackstage.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/30
 * Time: 10:28
 */
@Api(tags = "Order 订单接口")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/user/{userId}/status/{orderStatus}")
    @ApiOperation(value = "根据用户id以及订单状态获取订单")
    public Result listOrdersByStatus(
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId,
            @ApiParam(value = "订单状态", name = "orderStatus") @PathVariable("orderStatus") Integer orderStatus) {

        try {
            return Result.success( orderService.listOrdersByStatus(userId, orderStatus));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @GetMapping("/user/{userId}")
    @ApiOperation(value = "根据用户id获取全部订单")
    public Result listOrders(
            @ApiParam(value = "用户id", name = "userId") @PathVariable("userId") Integer userId) {

        try {
            return Result.success(orderService.listAllOrders(userId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @DeleteMapping("/{orderNo}")
    @ApiOperation(value = "删除已完成订单")
    public Result deleteOrder(
            @ApiParam(value = "订单号", name = "orderNo") @PathVariable("orderNo") String orderNo) {

        try {
            orderService.deleteOrder(orderNo);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @PutMapping("/{orderNo}/status/{orderStatus}")
    @ApiOperation(value = "修改订单状态")
    public Result deleteOrder(
            @ApiParam(value = "订单号", name = "orderNo") @PathVariable("orderNo") String orderNo,
            @ApiParam(value = "订单状态", name = "orderStatus") @PathVariable("orderStatus") Integer orderStatus) {

        try {
            orderService.updateOrderStatus(orderNo, orderStatus);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }
}
