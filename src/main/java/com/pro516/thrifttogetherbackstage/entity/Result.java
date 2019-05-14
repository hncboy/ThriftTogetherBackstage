package com.pro516.thrifttogetherbackstage.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 11:15
 */
@Getter
@Setter
@AllArgsConstructor
public class Result {

    private boolean success;
    private String message;
}
