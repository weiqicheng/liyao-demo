package com.liyao.backend.authentication.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

//@Component
public class MyFilter implements Filter {
    /**
     * 初始化方法
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter init");
    }
    /**
     * 过滤器处理逻辑方法
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter start");
        long start = System.currentTimeMillis();
        //让请求走下去
        filterChain.doFilter(servletRequest,servletResponse);
        //记录一下请求的耗时
        System.out.println("MyFilter ："+(System.currentTimeMillis()-start));
        System.out.println("MyFilter end");
    }
    /**
     * 销毁方法
     */
    @Override
    public void destroy() {
        System.out.println("MyFilter destroy");
    }
}
