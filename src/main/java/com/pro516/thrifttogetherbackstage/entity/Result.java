package com.pro516.thrifttogetherbackstage.entity;

import com.pro516.thrifttogetherbackstage.enums.ResultCode;
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

    private Integer code;

    private String message;

    private Object data;

    private Result() {}

    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result failure() {
        Result result = new Result();
        result.setResultCode(ResultCode.FAILURE);
        return result;
    }

    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    private void setResultCode(ResultCode code) {
        this.code = code.getCode();
        this.message = code.getMessage();
    }
}

