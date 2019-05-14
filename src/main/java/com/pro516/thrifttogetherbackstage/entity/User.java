package com.pro516.thrifttogetherbackstage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-13
 * Time: 14:18
 */
@Setter
@Getter
public class User {

    @ApiModelProperty(value = "用户id")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @JsonIgnore
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "头像url")
    private String avatorUrl;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "积分")
    private Integer integral;

    @JsonIgnore
    @ApiModelProperty(value = "注册时间")
    private Date createTime;

    @JsonIgnore
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
