package com.pro516.thrifttogetherbackstage.entity.vo;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/2
 * Time: 13:25
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@ApiModel(value = "ProductDetailsVO 团购详情信息")
public class ProductDetailsVO {

    @ApiModelProperty(value = "商品id")
    private Integer productId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品封面")
    private String productCoverUrl;

    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    @ApiModelProperty(value = "商品标签")
    private List<String> productTags;

    @ApiModelProperty(value = "套餐详情")
    private List<String> productContent;

    @ApiModelProperty(value = "温馨提醒")
    private List<String> productReminder;

    @ApiModelProperty(value = "团购价格")
    private Double productPrice;

    @ApiModelProperty(value = "商品原价")
    private Double productOriginalPrice;

    @ApiModelProperty(value = "商品折扣")
    private Double productDiscount;

    @ApiModelProperty(value = "商品销量")
    private Integer productSales;
}
