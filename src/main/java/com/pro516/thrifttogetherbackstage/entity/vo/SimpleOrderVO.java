package com.pro516.thrifttogetherbackstage.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/30
 * Time: 8:00
 */
@Setter
@Getter
@ApiModel(value = "SimpleOrderVO 显示的简单订单信息")
public class SimpleOrderVO {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "店铺类型")
    private Integer shopCategoryId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "店铺id")
    private Integer shopId;

    @ApiModelProperty(value = "商品封面")
    private String productCoverUrl;

    @ApiModelProperty(value = "商品总价")
    private Double productAmountTotal;

    @ApiModelProperty(value = "订单状态 1待付款 2待使用 3待评价 4表示已完成 5退款售后")
    private Integer orderStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value = "订单创建时间")
    private Date createTime;
}
