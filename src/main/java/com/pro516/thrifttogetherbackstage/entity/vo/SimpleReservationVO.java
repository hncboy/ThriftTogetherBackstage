package com.pro516.thrifttogetherbackstage.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/2
 * Time: 10:30
 */
@Setter
@Getter
@ApiModel(value = "SimpleReservationVO 显示在我的预约里的简单预约信息")
public class SimpleReservationVO {

    @ApiModelProperty(value = "预约id")
    private Integer reservationId;

    @ApiModelProperty(value = "预约店铺封面")
    private String shopCoverUrl;

    @ApiModelProperty(value = "预约店铺名称")
    private String shopName;

    @ApiModelProperty(value = "预约店铺区域")
    private String shopArea;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value = "预约时间")
    private Date reserveTime;

    @ApiModelProperty(value = "预定人数")
    private Integer reservationPeopleNum;

    @ApiModelProperty(value = "预约状态  0预约中 1已取消 2已过期")
    private Integer reservationStatus;
}
