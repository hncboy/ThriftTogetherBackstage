package com.pro516.thrifttogetherbackstage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/30
 * Time: 16:41
 */
@Setter
@Getter
@ApiModel(value = "Review 评价")
public class Review {

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "评价内容")
    private String reviewContent;

    @ApiModelProperty(value = "评论图片")
    private List<String> reviewPicUrlList;

    @JsonIgnore
    @ApiModelProperty(value = "评价店铺id")
    private Integer shopId;

    @JsonIgnore
    @ApiModelProperty(value = "评价商品id")
    private Integer productId;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "评价订单号")
    private Long orderNo;

    @ApiModelProperty(value = "评价分数")
    private Integer reviewScore;
}
