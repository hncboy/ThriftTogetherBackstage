package com.pro516.thrifttogetherbackstage.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/29
 * Time: 13:46
 */
@Setter
@Getter
@ApiModel(value = "CollectedProductVO 收藏的商品")
public class CollectedProductVO {

    @ApiModelProperty(value = "商品id")
    private Integer id;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品封面")
    private String coverUrl;

    @ApiModelProperty(value = "商品价格")
    private Double productPrice;

    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    @ApiModelProperty(value = "店铺区域")
    private String shopArea;
}
