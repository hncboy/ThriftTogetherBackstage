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
 * Date 2019/6/1
 * Time: 10:34
 */
@Setter
@Getter
@ApiModel(value = "SimpleUserCouponVO 简易的用户领取的优惠券")
public class SimpleUserCouponVO {

    @ApiModelProperty(value = "用户优惠卷id")
    private Integer userCouponId;

    @ApiModelProperty(value = "优惠券名称")
    private String couponName;

    @ApiModelProperty(value = "优惠卷图片url")
    private String couponImageUrl;

    @ApiModelProperty(value = "优惠卷折扣价格")
    private Integer couponDiscountedPrice;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "优惠卷过期时间")
    private Date expiredDate;

    @ApiModelProperty(value = "优惠卷状态 1已使用 2未使用 3已过期")
    private Integer userCouponStatus;
}
