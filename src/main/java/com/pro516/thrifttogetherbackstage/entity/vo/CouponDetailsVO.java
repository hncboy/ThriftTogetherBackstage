package com.pro516.thrifttogetherbackstage.entity.vo;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/1
 * Time: 9:41
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@ApiModel(value = "CouponDetailsVO 优惠券详细信息")
public class CouponDetailsVO {

    @ApiModelProperty(value = "优惠卷id")
    private Integer couponId;

    @ApiModelProperty(value = "优惠卷所需积分")
    private Integer couponIntegral;

    @ApiModelProperty(value = "优惠卷详情图片url")
    private String couponDetailsImageUrl;

    @ApiModelProperty(value = "优惠卷信息")
    private String couponInfo;

    @ApiModelProperty(value = "优惠卷兑换信息")
    private String couponExchangeInfo;

    @JsonIgnore
    @ApiModelProperty(value = "优惠卷折扣价格")
    private Integer couponDiscountedPrice;

    @JsonIgnore
    @ApiModelProperty(value = "优惠卷过期时间")
    private Date expiredDate;
}
