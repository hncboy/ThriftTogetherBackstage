package com.pro516.thrifttogetherbackstage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 11:44
 */
@Setter
@Getter
@ApiModel(value = "Banner 轮播图")
public class Banner {

    @ApiModelProperty(value = "轮播图id")
    private Integer id;

    @ApiModelProperty(value = "轮播图url")
    private String bannerCoverUrl;
}
