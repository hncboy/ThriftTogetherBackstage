package com.pro516.thrifttogetherbackstage.exception;

import com.pro516.thrifttogetherbackstage.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/1
 * Time: 20:44
 * 异常处理
 */
@RestController
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler
    public Result defaultErrorHandler(Exception e) {
        e.printStackTrace();
        return Result.failure();
    }
}
