package com.tr.springboot.web.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器管理类（已废弃，此类功能交由 shiro 完成 ———— 2022.07.08）
 *
 * @author: rtao
 * @date: 2021/4/21 20:24
 **/
@Configuration
public class WebMvc implements WebMvcConfigurer {

    @Autowired
    private Interceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /**
         * 以下拦截器可以复制多个同时使用
         */
        registry.addInterceptor(interceptor)
                .addPathPatterns(		// 需要拦截的 url
                        new String[] { "/**" })
                .excludePathPatterns(	// 排除拦截的 url
                        new String[] {
                                "/swagger-resources/**",
                                "/user/login"
                        });

    }

}
