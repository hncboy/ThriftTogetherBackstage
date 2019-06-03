package com.pro516.thrifttogetherbackstage.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/3
 * Time: 10:02
 */

@Setter
@Getter
@ApiModel(value = "LookingAroundShopVO 随便看看店铺信息")
public class LookingAroundShopVO {

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

    @ApiModelProperty(value = "店铺位置")
    private String shopAddress;

    @ApiModelProperty(value = "城市id")
    private Integer cityId;

    @ApiModelProperty(value = "店铺团购名称列表")
    private List<String> productNameList;

    @ApiModelProperty(value = "用户是否收藏 0不收藏 1收藏")
    private Integer isCollected;
}
