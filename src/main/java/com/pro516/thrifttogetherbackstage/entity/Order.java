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
@ApiModel(value = "Order 订单")
public class Order {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "店铺id")
    private Integer shopId;

    @ApiModelProperty(value = "商品id")
    private Integer productId;

    @ApiModelProperty(value = "商品价格")
    private Integer productCount;

    @ApiModelProperty(value = "商品总价")
    private Double productAmountTotal;

    @ApiModelProperty(value = "付款方式 1支付宝 2微信")
    private Integer paymentMethod;

    @ApiModelProperty(value = "订单状态 1表示待付款 2表示待使用 3表示待评价 4表示已完成")
    private Integer orderStatus;

    @ApiModelProperty(value = "订单创建时间")
    private Date createTime;

    @ApiModelProperty(value = "订单付款时间")
    private Date payTime;

    @ApiModelProperty(value = "使用时间")
    private Date useTime;

    @ApiModelProperty(value = "评价时间")
    private Date reviewTime;
}
