package com.pro516.thrifttogetherbackstage.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/30
 * Time: 18:56
 */
@Setter
@Getter
@ApiModel(value = "SimpleReviewVO 显示在店铺里的评价信息")
public class SimpleReviewVO {

    @ApiModelProperty(value = "评价id")
    private Integer reviewId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户头像")
    private String avatorUrl;

    @ApiModelProperty(value = "评价内容")
    private String reviewContent;

    @ApiModelProperty(value = "评论图片")
    private List<String> reviewPicUrlList;

    @ApiModelProperty(value = "评价分数")
    private Integer reviewScore;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "评价时间")
    private Date reviewTime;
}
