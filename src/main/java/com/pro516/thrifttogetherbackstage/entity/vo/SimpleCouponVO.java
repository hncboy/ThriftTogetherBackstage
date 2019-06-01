package com.pro516.thrifttogetherbackstage.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/1
 * Time: 9:17
 */
@Setter
@Getter
@ApiModel(value = "SimpleCouponVO 显示在商城首页的优惠券信息")
public class SimpleCouponVO {

    @ApiModelProperty(value = "优惠券id")
    private Integer couponId;

    @ApiModelProperty(value = "优惠券名称")
    private String couponName;

    @ApiModelProperty(value = "优惠券所需积分")
    private Integer couponIntegral;

    @ApiModelProperty(value = "优惠券图片url")
    private String couponImageUrl;
}
