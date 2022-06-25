package com.tr.springboot.web.common.advice;

import com.tr.springboot.web.common.exception.MyException;
import com.tr.springboot.web.common.result.Result;
import com.tr.springboot.web.common.result.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller 统一异常处理
 *
 * @author TR
 * @date 2022/6/25 上午8:56
 */
@RestControllerAdvice
public class ControllerExceptionAdvice {

    private final static Logger logger = LoggerFactory.getLogger(ControllerExceptionAdvice.class);

    @ExceptionHandler(Exception.class)
    public Result handle(Exception e) {
        if (e instanceof MyException) {
            MyException myException = (MyException) e;
            return Result.fail(myException.getCode(), myException.getMessage());
        } else {
            logger.error("[系统异常]", e);
            return Result.fail(ResultEnum.UNKNOWN_ERROR.getCode(), e.getMessage());
        }
    }

}
