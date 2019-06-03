package com.pro516.thrifttogetherbackstage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/3
 * Time: 8:29
 */
@Setter
@Getter
@ApiModel(value = "Order 订单（内部使用）")
public class Product {

    @ApiModelProperty(value = "商品id")
    private Integer productId;

    @ApiModelProperty(value = "店铺id")
    private Integer shopId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品标签")
    private List<String> productTags;

    @ApiModelProperty(value = "商品详情")
    private List<String> productContent;

    @ApiModelProperty(value = "温馨提醒")
    private List<String> productReminder;

    @ApiModelProperty(value = "商品封面")
    private String productCoverUrl;

    @ApiModelProperty(value = "团购价格")
    private Double productPrice;

    @ApiModelProperty(value = "商品原价")
    private Double productOriginalPrice;

    @ApiModelProperty(value = "商品折扣")
    private Double productDiscount;

    @ApiModelProperty(value = "商品销量")
    private Integer productSales;

    @ApiModelProperty(value = "商品使用时间")
    private String productUseTime;
}
