package com.tr.springboot.web.interceptor;

import com.tr.springboot.web.common.exception.MyException;
import com.tr.springboot.web.common.result.ResultEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器（已废弃，此类功能交由 shiro 完成 ———— 2022.07.08）
 *
 * @author: rtao
 * @date: 2021/4/21 20:35
 **/
@Component
public class Interceptor implements AsyncHandlerInterceptor {

    @Value(value = "${local.develop}")
    private boolean localDevelop;

    private static final String SESSION_ATTR_USER = "user";

    /**
     * 返回 true 继续向下执行，返回 false 取消当前请求
     *
     * @author: rtao
     * @date: 2021/4/21 20:35
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            Object user = request.getSession().getAttribute(SESSION_ATTR_USER);
            if (user == null) {
                if (!localDevelop) {
                    throw new MyException(ResultEnum.NO_LOGIN);
                }
            }
        }
        return true; // 只有返回 true 才会继续向下执行，返回 false 取消当前请求
    }

}
