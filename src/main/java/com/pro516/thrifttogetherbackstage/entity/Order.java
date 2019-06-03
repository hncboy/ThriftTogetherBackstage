package com.pro516.thrifttogetherbackstage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/30
 * Time: 8:00
 */
@Setter
@Getter
@ApiModel(value = "Order 订单（内部使用）")
public class Order {

    @ApiModelProperty(value = "订单号")
    private Long orderNo;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "商品id")
    private Integer productId;

    @ApiModelProperty(value = "商品数量")
    private Integer productCount;

    @ApiModelProperty(value = "商品总价")
    private Double productAmountTotal;

    @ApiModelProperty(value = "付款方式 1支付宝 2微信")
    private Integer paymentMethod;

    @ApiModelProperty(value = "订单状态 1待付款 2待使用 3待评价 4已完成 5退款售后")
    private Integer orderStatus;

    @ApiModelProperty(value = "下单时间")
    private Date createTime;

    @ApiModelProperty(value = "付款时间")
    private Date payTime;

    @ApiModelProperty(value = "使用时间")
    private Date useTime;

    @ApiModelProperty(value = "评价时间")
    private Date reviewTime;

    @ApiModelProperty(value = "售后时间")
    private Date afterSaleTime;
}
