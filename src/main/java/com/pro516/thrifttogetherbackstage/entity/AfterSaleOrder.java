package com.pro516.thrifttogetherbackstage.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/3
 * Time: 21:01
 */
@Setter
@Getter
@ApiModel(value = "AfterSaleOrder 售后订单")
public class AfterSaleOrder {

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "订单号")
    private Long orderNo;

    @ApiModelProperty(value = "退款原因")
    private String refundReason;

    @ApiModelProperty(value = "退款说明")
    private String refundDescription;

    @ApiModelProperty(value = "退款凭照图片url集合")
    private List<String> certificateImageUrlList;
}
