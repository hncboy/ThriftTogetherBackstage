package com.pro516.thrifttogetherbackstage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/2
 * Time: 9:53
 */
@Setter
@Getter
@ApiModel(value = "Reservation 预约")
public class Reservation {

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "商家id")
    private Integer shopId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @ApiModelProperty(value = "预定时间")
    private Date reserveTime;

    @ApiModelProperty(value = "预定人数")
    private Integer reservationPeopleNum;

    @ApiModelProperty(value = "预约人姓名")
    private String reservationPeopleName;

    @ApiModelProperty(value = "预约人电话")
    private String reservationPeoplePhone;

    @ApiModelProperty(value = "预约留言")
    private String reservationRemarks;
}
