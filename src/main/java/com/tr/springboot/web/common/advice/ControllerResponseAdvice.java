package com.tr.springboot.web.common.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tr.springboot.web.common.annotation.NotControllerResponseAdvice;
import com.tr.springboot.web.common.exception.MyException;
import com.tr.springboot.web.common.result.Result;
import com.tr.springboot.web.common.result.ResultEnum;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author TR
 * @date 2022/6/25 上午9:24
 */
@RestControllerAdvice(basePackages = {"com.tr.springboot.web.controller.advice"})
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // response 是 Result 类型，或者注释了 NotControllerResponseAdvice 都不进行包装
        return !(methodParameter.getParameterType().isAssignableFrom(Result.class)
                || methodParameter.hasMethodAnnotation(NotControllerResponseAdvice.class));
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response) {
        // String 类型不能直接包装
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在 Result 里后转换为 json 串进行返回
                return objectMapper.writeValueAsString(Result.success(data));
            } catch (JsonProcessingException e) {
                throw new MyException(ResultEnum.RESPONSE_PACK_ERROR, e);
            }
        }
        // 否则直接包装成 Result 返回
        return Result.success(data);
    }
}