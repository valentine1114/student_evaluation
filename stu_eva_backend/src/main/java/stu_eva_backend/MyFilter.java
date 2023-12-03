package stu_eva_backend;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
//public class MyFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        // 在此处执行过滤器逻辑
//        System.out.println("=====doFilter=====");
//        // 继续处理请求
//        chain.doFilter(httpRequest, httpResponse);
//    }
//
//    // 可以在init()和destroy()方法中进行一些初始化和清理操作
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // 初始化过滤器
//        // 在此处执行过滤器逻辑
//        System.out.println("=====Filter init=====");
//    }
//
//    @Override
//    public void destroy() {
//        // 清理资源
//        System.out.println("=====Filter destroy=====");
//    }
//}