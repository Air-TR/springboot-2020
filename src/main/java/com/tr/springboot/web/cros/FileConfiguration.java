//package com.tr.springboot.web.cros;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.DefaultCorsProcessor;
//import org.springframework.web.filter.CorsFilter;
//
//import java.util.Arrays;
//import java.util.Collections;
//
///**
// * @author rtao
// * @date 2021/4/23 10:58
// */
//@Configuration
//public class FileConfiguration {
//
//    @Bean
//    public FilterRegistrationBean<CorsFilter> corsFilterFilterRegistrationBean() {
//
//        FilterRegistrationBean<CorsFilter> corsFilterFilterRegistrationBean = new FilterRegistrationBean<>();
//
//        CorsFilter corsFilter = new CorsFilter((request) -> {
//            CorsConfiguration corsConfiguration = new CorsConfiguration();
//            corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","DELETE","PUT"));
//            corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));
//            corsConfiguration.setAllowedOrigins(Collections.singletonList("*"));
//            corsConfiguration.setAllowedHeaders(Arrays.asList("content-type", "JSESSIONID"));
//            return corsConfiguration;
//        });
//        corsFilter.setCorsProcessor(new DefaultCorsProcessor());
//        corsFilterFilterRegistrationBean.setFilter(corsFilter);
//        corsFilterFilterRegistrationBean.setUrlPatterns(Collections.singletonList("/*"));
//        return corsFilterFilterRegistrationBean;
//    }
//
//}
