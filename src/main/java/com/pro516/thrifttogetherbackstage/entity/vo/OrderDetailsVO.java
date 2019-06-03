package com.pro516.thrifttogetherbackstage.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/3
 * Time: 7:58
 */

@Setter
@Getter
@ApiModel(value = "OrderDetailsVO 订单详情")
public class OrderDetailsVO {

    @ApiModelProperty(value = "订单号")
    private Long orderNo;

    @JsonIgnore
    @ApiModelProperty(value = "购买商品id")
    private Integer productId;

    @ApiModelProperty(value = "购买商品名称")
    private String productName;

    @ApiModelProperty(value = "购买商品封面")
    private String productCoverUrl;

    @ApiModelProperty(value = "购买商品单价")
    private Double productBuyPrice;

    @ApiModelProperty(value = "购买数量")
    private Integer productCount;

    @ApiModelProperty(value = "是否使用优惠券 0不使用 1使用")
    private Integer isUseCoupon;

    @JsonIgnore
    @ApiModelProperty(value = "使用的用户优惠券id，不使用为0")
    private Integer userCouponId;

    @ApiModelProperty(value = "优惠券折扣价格")
    private Integer discountedPrice;

    @ApiModelProperty(value = "订单总价")
    private Double productAmountTotal;

    @ApiModelProperty(value = "联系电话")
    private String contactPhone;

    @ApiModelProperty(value = "付款方式 1支付宝 2微信")
    private Integer paymentMethod;

    @ApiModelProperty(value = "订单状态 1待付款 2待使用 3待评价 4表示已完成 5退款售后")
    private Integer orderStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value = "订单创建时间")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value = "订单付款时间")
    private Date payTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value = "订单使用时间")
    private Date useTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value = "订单评价时间")
    private Date reviewTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value = "订单退款售后时间")
    private Date afterSaleTime;
}
