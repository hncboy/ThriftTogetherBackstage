package com.pro516.thrifttogetherbackstage.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/29
 * Time: 13:45
 */
@Setter
@Getter
@ApiModel(value = "CollectedShopVO 收藏的店铺")
public class CollectedShopVO {

    @ApiModelProperty(value = "店铺id")
    private Integer id;

    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    @ApiModelProperty(value = "店铺封面")
    private String coverUrl;

    @ApiModelProperty(value = "店铺评分")
    private Double averageScore;

    @ApiModelProperty(value = "人均价格")
    private Integer averagePrice;

    @ApiModelProperty(value = "店铺区域")
    private String shopArea;
}
