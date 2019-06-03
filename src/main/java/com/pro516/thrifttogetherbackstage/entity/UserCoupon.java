package com.pro516.thrifttogetherbackstage.entity;

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
 * Time: 8:51
 */

@Setter
@Getter
@ApiModel(value = "UserCoupon 用户优惠券（内部使用）")
public class UserCoupon {

    @ApiModelProperty(value = "用户优惠卷id")
    private Integer userCouponId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "优惠券id")
    private Integer couponId;

    @ApiModelProperty(value = "优惠卷领取时间")
    private Date receiveTime;

    @ApiModelProperty(value = "优惠卷使用时间")
    private Date useTime;

    @ApiModelProperty(value = "使用的订单号")
    private Long useOrderNo;

    @ApiModelProperty(value = "优惠卷状态 1已使用 2未使用 3已过期")
    private Integer userCouponStatus;
}
