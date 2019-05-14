package com.pro516.thrifttogetherbackstage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 9:51
 */
@Setter
@Getter
@ApiModel(value = "Coupon 优惠券")
public class Coupon {

    @ApiModelProperty(value = "优惠券id")
    private Integer id;

    @ApiModelProperty(value = "优惠券名称")
    private String couponName;

    @ApiModelProperty(value = "优惠券所需积分")
    private Integer couponIntegral;

    @ApiModelProperty(value = "优惠券图片url")
    private String couponImageUrl;

    @ApiModelProperty(value = "优惠卷折扣价格")
    private Integer discountedPrices;

    @ApiModelProperty(value = "优惠卷兑换次数")
    private Integer exchangeNumber;

    @ApiModelProperty(value = "优惠卷总数")
    private Integer couponTotal;

    @JsonIgnore
    @ApiModelProperty(value = "优惠卷状态 1为正在发售 2为已售空 3为已下架")
    private Integer couponStatus;

    @JsonIgnore
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @JsonIgnore
    @ApiModelProperty(value = "售空时间")
    private Date sellOutTime;

    @JsonIgnore
    @ApiModelProperty(value = "下架时间")
    private Date removedTime;
}
