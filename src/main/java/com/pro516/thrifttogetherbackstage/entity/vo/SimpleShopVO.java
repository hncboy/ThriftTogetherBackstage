package com.pro516.thrifttogetherbackstage.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/30
 * Time: 12:24
 */
@Setter
@Getter
@ApiModel(value = "SimpleShopVO 显示的简单店铺信息")
public class SimpleShopVO {

    @ApiModelProperty(value = "店铺id")
    private Integer shopId;

    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    @ApiModelProperty(value = "店铺封面")
    private String shopCoverUrl;

    @ApiModelProperty(value = "店铺评分")
    private Double averageScore;

    @ApiModelProperty(value = "人均价格")
    private Integer averagePrice;

    @ApiModelProperty(value = "店铺区域")
    private String shopArea;
}
