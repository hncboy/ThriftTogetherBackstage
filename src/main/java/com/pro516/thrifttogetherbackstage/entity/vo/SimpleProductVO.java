package com.pro516.thrifttogetherbackstage.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/31
 * Time: 10:45
 */
@Setter
@Getter
@ApiModel(value = "SimpleProductVO 店铺里的简单团购信息")
public class SimpleProductVO {

    @ApiModelProperty(value = "商品id")
    private Integer productId;

    @ApiModelProperty(value = "商品封面")
    private String productCoverUrl;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品使用时间")
    private String productUseTime;

    @ApiModelProperty(value = "商品价格")
    private Double productPrice;
}
