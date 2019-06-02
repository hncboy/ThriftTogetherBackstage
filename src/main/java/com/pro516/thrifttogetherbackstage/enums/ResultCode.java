package com.pro516.thrifttogetherbackstage.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * API 统一返回状态码
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

    SUCCESS(200, "成功"),
    FAILURE(500, "失败"),

    USER_LOGIN_ERROR(10001, "手机号或密码错误");

    private Integer code;

    private String message;
}
