package com.pro516.thrifttogetherbackstage.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/31
 * Time: 10:41
 */
@Setter
@Getter
@ApiModel(value = "ShopDetailsVO 店铺详细信息")
public class ShopDetailsVO {

    @ApiModelProperty(value = "店铺id")
    private Integer shopId;

    @ApiModelProperty(value = "店铺封面")
    private String shopCoverUrl;

    @ApiModelProperty(value = "店铺名")
    private String shopName;

    @ApiModelProperty(value = "店铺评分")
    private Double shopAverageScore;

    @ApiModelProperty(value = "人均价格")
    private Integer shopAveragePrice;

    @ApiModelProperty(value = "店铺位置")
    private String shopAddress;

    @ApiModelProperty(value = "店铺团购列表信息")
    private List<SimpleProductVO> simpleProductList;

    @ApiModelProperty(value = "用户是否收藏 0不收藏 1收藏")
    private Integer isCollected;
}
