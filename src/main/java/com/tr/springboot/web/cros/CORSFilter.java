//package com.tr.springboot.web.cros;
//
//import org.springframework.stereotype.Component;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author rtao
// * @date 2021/5/19 19:26
// */
//@Component
//public class CORSFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletResponse res = (HttpServletResponse) response;
//        res.addHeader("Access-Control-Allow-Credentials", "true");
//        res.addHeader("Access-Control-Allow-Origin", "http://192.168.64.25:3000, http://192.168.64.76:8083");
//        res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
//        res.addHeader("Access-Control-Allow-Headers", "Content-Type,X-CAF-Authorization-Token,sessionToken,X-TOKEN");
//        if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
//            response.getWriter().println("ok");
//            return;
//        }
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//}
