package com.tr.springboot.web.common.exception;

import com.tr.springboot.web.common.result.Result;
import com.tr.springboot.web.common.result.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 *
 * @author taorun
 * 2017/8/7 下午4:17
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
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
