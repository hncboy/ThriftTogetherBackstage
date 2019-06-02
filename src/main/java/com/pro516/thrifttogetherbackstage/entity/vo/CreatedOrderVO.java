package com.pro516.thrifttogetherbackstage.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/2
 * Time: 14:56
 */
@Setter
@Getter
@ApiModel(value = "CreatedOrderVO 创建的订单")
public class CreatedOrderVO {

    @JsonIgnore
    @ApiModelProperty(value = "订单号")
    private Long orderNo;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "购买商品id")
    private Integer productId;

    @ApiModelProperty(value = "购买商品单价")
    private Double productBuyPrice;

    @ApiModelProperty(value = "购买数量")
    private Integer productCount;

    @ApiModelProperty(value = "是否使用优惠券 0不使用 1使用")
    private Integer isUseCoupon;

    @ApiModelProperty(value = "使用的用户优惠券id")
    private Integer userCouponId;

    @ApiModelProperty(value = "订单总价")
    private Double productAmountTotal;

    @ApiModelProperty(value = "联系电话")
    private String contactPhone;
}
