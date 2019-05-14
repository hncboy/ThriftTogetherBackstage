package com.pro516.thrifttogetherbackstage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 12:49
 */
@Setter
@Getter
@ApiModel(value = "Shop 店铺")
public class Shop {

    @ApiModelProperty(value = "店铺id")
    private Integer id;

    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    @ApiModelProperty(value = "细分名称")
    private String subdivisionName;

    @ApiModelProperty(value = "店铺封面")
    private String coverUrl;

    @ApiModelProperty(value = "店铺评分")
    private Double averageScore;

    @ApiModelProperty(value = "人均价格")
    private Integer averagePrice;

    @ApiModelProperty(value = "店铺区域")
    private String shopArea;

    @ApiModelProperty(value = "店铺位置")
    private String shopAddress;

    @ApiModelProperty(value = "经度")
    private Double longitude;

    @ApiModelProperty(value = "纬度")
    private Double latitude;

    @JsonIgnore
    @ApiModelProperty(value = "分类id")
    private Integer categoryId;

    @JsonIgnore
    @ApiModelProperty(value = "细分种类id")
    private Integer subdivisionId;

    @JsonIgnore
    @ApiModelProperty(value = "所在城市id")
    private Integer cityId;

    @JsonIgnore
    @ApiModelProperty(value = "店铺创建时间")
    private Date createTime;
}
